package serde

import io.circe.Json

object Deserializer extends ProjectEncoderDecoder {

  def fromString(str: String): Json = {
    import io.circe._
    import io.circe.parser._
    parse(str) match {
      case Right(r) ⇒ r
      case _        ⇒ Json.Null
    }
  }
}
