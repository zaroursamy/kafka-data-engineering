package main

import com.redis.RedisClient
import com.typesafe.config.ConfigFactory
import config.KafkaConfig.getConsumerProps
import config.{ KafkaConfig, TweetConsumerProps, TypeSafeParams }
import kafka.{ ProjectStreams, Topics }
import org.apache.kafka.clients.consumer.KafkaConsumer
import projectapi.redis.RedisClient.getRedisClient

/**
 * Fetch data from Kafka and push into Redis
 */
object FromKafkaToDb {

  def main(args: Array[String]): Unit = {

    val params = TypeSafeParams.getParams(args)

    val conf = ConfigFactory.load()

    val kafkaConfig: KafkaConfig = KafkaConfig.genKafkaConf(params, conf)

    val props = getConsumerProps(kafkaConfig)(TweetConsumerProps.STRING_DESERIALIZER, TweetConsumerProps.STRING_DESERIALIZER)._1

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)

    implicit val r: RedisClient = getRedisClient(conf, params)
    import projectapi.Api.modelDatabaseApi
    ProjectStreams.runLoop(consumer, Topics.getInputTopic(conf, params))

  }
}
