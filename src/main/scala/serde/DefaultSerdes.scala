package serde

import model.sink.{ ModelDatabase, ModelMarioFr, ModelMedias }
import model.source.TweetFull
import org.apache.kafka.common.serialization.{ Serde, Serdes }

/**
 * Contains Serde for Kafka
 */
object DefaultSerdes {

  implicit val tweetSerde: Serde[TweetFull] = new JsonSerde[TweetFull]
  implicit val marioFRSerde: Serde[ModelMarioFr] = new JsonSerde[ModelMarioFr]
  implicit val modelAerospikeSerde: Serde[ModelDatabase] = new JsonSerde[ModelDatabase]
  implicit val modelMedias: Serde[ModelMedias] = new JsonSerde[ModelMedias]

  implicit val stringSerde: Serde[String] = Serdes.String()
  implicit val longSerde: Serde[Long] = Serdes.Long().asInstanceOf[Serde[Long]]
  implicit val byteArraySerde: Serde[Array[Byte]] = Serdes.ByteArray()
  implicit val bytesSerde: Serde[org.apache.kafka.common.utils.Bytes] = Serdes.Bytes()
  implicit val floatSerde: Serde[Float] = Serdes.Float().asInstanceOf[Serde[Float]]
  implicit val doubleSerde: Serde[Double] = Serdes.Double().asInstanceOf[Serde[Double]]
  implicit val integerSerde: Serde[Int] = Serdes.Integer().asInstanceOf[Serde[Int]]

}