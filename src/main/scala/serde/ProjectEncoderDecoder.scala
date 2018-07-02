package serde

import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }
import io.circe.{ Decoder, Encoder }
import model.sink.{ ModelDatabase, ModelMarioFr, ModelMedias }
import model.source._

trait ProjectEncoderDecoder {
  implicit val hashDecoder: Decoder[Hashtag] = deriveDecoder[Hashtag]
  implicit val hashEncoder: Encoder[Hashtag] = deriveEncoder[Hashtag]

  implicit val sizeDecoder: Decoder[Size] = deriveDecoder[Size]
  implicit val sizeEncoder: Encoder[Size] = deriveEncoder[Size]

  implicit val sizesDecoder: Decoder[Sizes] = deriveDecoder[Sizes]
  implicit val sizesEncoder: Encoder[Sizes] = deriveEncoder[Sizes]

  implicit val mediaDecoder: Decoder[Media] = deriveDecoder[Media]
  implicit val mediaEncoder: Encoder[Media] = deriveEncoder[Media]

  implicit val urlDecoder: Decoder[Url] = deriveDecoder[Url]
  implicit val urlEncoder: Encoder[Url] = deriveEncoder[Url]

  implicit val usrmentionDecoder: Decoder[UserMention] = deriveDecoder[UserMention]
  implicit val usrmentionEncoder: Encoder[UserMention] = deriveEncoder[UserMention]

  implicit val entitiesDecoder: Decoder[Entities] = deriveDecoder[Entities]
  implicit val entitiesEncoder: Encoder[Entities] = deriveEncoder[Entities]

  implicit val contDecoder: Decoder[Contributor] = deriveDecoder[Contributor]
  implicit val contEncoder: Encoder[Contributor] = deriveEncoder[Contributor]

  implicit val curDecoder: Decoder[CurrentUserRetweet] = deriveDecoder[CurrentUserRetweet]
  implicit val curEncoder: Encoder[CurrentUserRetweet] = deriveEncoder[CurrentUserRetweet]

  implicit val coorDecoder: Decoder[Coordinates] = deriveDecoder[Coordinates]
  implicit val coorEncoder: Encoder[Coordinates] = deriveEncoder[Coordinates]

  implicit val placecoordDecoder: Decoder[PlaceCoordinates] = deriveDecoder[PlaceCoordinates]
  implicit val placecoordEncoder: Encoder[PlaceCoordinates] = deriveEncoder[PlaceCoordinates]

  implicit val placeDecoder: Decoder[Place] = deriveDecoder[Place]
  implicit val placeEncoder: Encoder[Place] = deriveEncoder[Place]

  implicit val usrDecoder: Decoder[User] = deriveDecoder[User]
  implicit val usrEncoder: Encoder[User] = deriveEncoder[User]

  implicit val twDecoder: Decoder[Tweet] = deriveDecoder[Tweet]
  implicit val twEncoder: Encoder[Tweet] = deriveEncoder[Tweet]

  implicit val usrFDecoder: Decoder[UserFull] = deriveDecoder[UserFull]
  implicit val usrFEncoder: Encoder[UserFull] = deriveEncoder[UserFull]

  implicit val tfDecoder: Decoder[TweetFull] = deriveDecoder[TweetFull]
  implicit val tfEncoder: Encoder[TweetFull] = deriveEncoder[TweetFull]

  implicit val mmediaDecoder: Decoder[ModelMedias] = deriveDecoder[ModelMedias]
  implicit val mmediaEncoder: Encoder[ModelMedias] = deriveEncoder[ModelMedias]

  implicit val mfrDecoder: Decoder[ModelMarioFr] = deriveDecoder[ModelMarioFr]
  implicit val mfrEncoder: Encoder[ModelMarioFr] = deriveEncoder[ModelMarioFr]

  implicit val aeDecoder: Decoder[ModelDatabase] = deriveDecoder[ModelDatabase]
  implicit val aeEncoder: Encoder[ModelDatabase] = deriveEncoder[ModelDatabase]

}

