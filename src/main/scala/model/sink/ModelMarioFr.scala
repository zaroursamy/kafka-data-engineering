package model.sink

import model.source.{ Hashtag, TweetFull }
import util.DateUtil

case class ModelMarioFr(
    id:          Long,
    user_id:     Long,
    screen_name: String,
    created_at:  String,
    text:        String,
    medias:      Option[Seq[ModelMedias]],
    hashtags:    Option[Seq[Hashtag]])

object ModelMarioFr {

  import `implicit`.Implicit.EntitiesImplicit

  def apply(tweetFull: TweetFull): Option[ModelMarioFr] = {

    import tweetFull._
    for (
      u ← user;
      createdAtConverted ← DateUtil.convertTweetCreatedAt(created_at)
    ) yield ModelMarioFr(
      id          = id,
      user_id     = u.id,
      screen_name = u.screen_name,
      created_at  = createdAtConverted,
      text        = text,
      medias      = Option(entities.getMedia),
      hashtags    = Option(entities.getHashtags))

  }
}