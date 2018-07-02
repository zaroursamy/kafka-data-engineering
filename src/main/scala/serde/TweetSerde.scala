package serde

import io.circe.Json
import model.sink.ModelMarioFr
import model.source.TweetFull

object TweetSerde extends ProjectEncoderDecoder {

  /**
   * Map a ModelMarioFr into Json (for push in Kafka)
   * @param t
   * @return
   */
  def toJson(t: ModelMarioFr): Json = {
    import io.circe.syntax._
    t.asJson
  }

  /**
   * Map a String into an optional TweetFull
   * @param s
   * @return
   */
  def fromJson(s: String): Option[TweetFull] = {
    import io.circe._
    import io.circe.parser._

    val json: Json = parse(s).getOrElse(Json.Null)
    json.as[TweetFull].fold(_ ⇒ None, Option(_))

  }

}