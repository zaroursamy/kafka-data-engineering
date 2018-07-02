package serde

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
//import com.typesafe.scalalogging.LazyLogging

import scala.reflect.{ ClassTag, classTag }

class JsonSerde[T >: Null: ClassTag] extends BaseSerde[T] {

  val mapper = new ObjectMapper
  mapper.registerModule(DefaultScalaModule)

  override def deserialize(topic: String, data: Array[Byte]): T = data match {
    case null ⇒ null
    case _ ⇒
      try {
        mapper.readValue(data, classTag[T].runtimeClass.asInstanceOf[Class[T]])
      } catch {
        case e: Exception ⇒
          val jsonStr = new String(data, "UTF-8")
          e.printStackTrace()
          println(s"Problem in json: $jsonStr")
          null
      }
  }

  override def serialize(topic: String, obj: T): Array[Byte] = {
    mapper.writeValueAsBytes(obj)
  }

}

