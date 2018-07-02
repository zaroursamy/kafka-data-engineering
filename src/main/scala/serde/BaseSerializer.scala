package serde

import java.util
import org.apache.kafka.common.serialization.Serializer

abstract class BaseSerializer[T] extends Serializer[T] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

}

object BaseSerializer {

  def apply[T](func: (String, T) ⇒ Array[Byte]): BaseSerializer[T] = new BaseSerializer[T] {
    override def serialize(topic: String, data: T): Array[Byte] = func(topic, data)
  }

}