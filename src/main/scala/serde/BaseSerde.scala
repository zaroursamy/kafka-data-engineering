package serde

import java.util
import org.apache.kafka.common.serialization.Serde

abstract class BaseSerde[T] extends Serde[T] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def serializer() = BaseSerializer(serialize)

  override def deserializer() = BaseDeserializer(deserialize)

  def serialize(topic: String, data: T): Array[Byte]

  def deserialize(topic: String, data: Array[Byte]): T

}

