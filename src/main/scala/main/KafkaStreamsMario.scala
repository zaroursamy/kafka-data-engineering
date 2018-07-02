package main

import com.lightbend.kafka.scala.streams.{ KStreamS, StreamsBuilderS }
import com.typesafe.config.ConfigFactory
import config.{ KafkaConfig, TypeSafeParams }
import kafka.{ ProjectStreams, Topics }
import org.apache.kafka.streams.KafkaStreams
import serde.ProjectEncoderDecoder

/**
 * Streams between 2 topics
 */
object KafkaStreamsMario extends ProjectEncoderDecoder {

  import serde.DefaultSerdes._
  marioFRSerde
  tweetSerde

  def main(args: Array[String]): Unit = {

    val params = TypeSafeParams.getParams(args)

    val conf = ConfigFactory.load()

    val kafkaConfig: KafkaConfig = KafkaConfig.genKafkaConf(params, conf)

    val builder = new StreamsBuilderS

    val tweets = builder.stream[String, String](Topics.getInputTopic(conf, params))

    val streamMarioFr: KStreamS[String, String] = ProjectStreams.tweetsToMarioFr(tweets)

    streamMarioFr.to(Topics.getOutputMarioFrTopic(conf, params))

    val streams = new KafkaStreams(builder.build(), KafkaConfig.getMarioStreamsProps(kafkaConfig)._1)

    streams.start()
  }

}

