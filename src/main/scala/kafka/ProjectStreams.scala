package kafka

import `implicit`.Implicit._
import com.lightbend.kafka.scala.streams.KStreamS
import com.redis.RedisClient
import model.ProjectMonoids.monoidDatabase
import model.sink.{ ModelDatabase, ModelMarioFr }
import org.apache.kafka.clients.consumer.KafkaConsumer
import projectapi.Api
import serde.DefaultSerdes._
import serde.TweetSerde._
import serde.{ ProjectEncoderDecoder, TweetSerde }
import validator.TweetValidator.isMarioFr

object ProjectStreams extends ProjectEncoderDecoder {

  tweetSerde
  marioFRSerde
  modelAerospikeSerde

  /**
   * Create tweet stream containing "mario" in text and lang=fr
   *
   * @param tweets
   * @return
   */
  def tweetsToMarioFr(tweets: KStreamS[String, String]): KStreamS[String, String] = tweets
    .flatMapValues(s ⇒ fromJson(s).toIterable)
    .filter { case (_, tweetFull) ⇒ isMarioFr(tweetFull) }
    .flatMapValues(tf ⇒ ModelMarioFr.apply(tf).toIterable)
    .mapValues(marioFr ⇒ toJson(marioFr).toString)

  /**
   * Insert Kafka records into database
   * @param consumer
   * @param topic
   * @param modelDatabaseApi
   * @param r
   */
  def runLoop(consumer: KafkaConsumer[String, String], topic: String)(implicit modelDatabaseApi: Api[ModelDatabase], r: RedisClient): Unit = {
    import scala.collection.JavaConverters._

    consumer.subscribe(java.util.Collections.singletonList(topic))

    try {

      while (true) {

        val records = consumer.poll(1000)

        val recordsSeq = records.asScala.toSeq

        val dbModel: Seq[ModelDatabase] = recordsSeq.flatMap(r ⇒ TweetSerde.fromJson(r.value())).toModelDatabase

        dbModel.foreach { model: ModelDatabase ⇒

          // update stats by user
          modelDatabaseApi.updateById(model.userId, model)
        }

        Thread.sleep(10000)
      }
    } finally {
      consumer.close()
    }
  }

}
