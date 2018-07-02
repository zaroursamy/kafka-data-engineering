package serde

import java.util
import org.apache.kafka.common.serialization.Deserializer

abstract class BaseDeserializer[T] extends Deserializer[T] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

}

object BaseDeserializer {

  def apply[T](func: (String, Array[Byte]) ⇒ T): BaseDeserializer[T] = new BaseDeserializer[T] {
    override def deserialize(topic: String, data: Array[Byte]): T = func(topic, data)
  }

}