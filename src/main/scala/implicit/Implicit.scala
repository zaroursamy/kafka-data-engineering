package `implicit`

import cats.Semigroup
import model.sink.{ ModelDatabase, ModelMedias }
import model.source._

object Implicit {

  /**
   * Get nested objects from Entities
   * @param entities
   */
  implicit class EntitiesImplicit(entities: Option[Entities]) {

    def getMentions: Seq[UserMention] = entities
      .flatMap(_.user_mentions)
      .getOrElse(Seq.empty)

    def getMedia: Seq[ModelMedias] = entities
      .flatMap(_.media)
      .getOrElse(Seq.empty)
      .map(m ⇒ ModelMedias(m.id, m.media_url_https))

    def getHashtags: Seq[Hashtag] = entities
      .flatMap(_.hashtags)
      .getOrElse(Seq.empty)
  }

  /**
   * Get id from user
   * @param user
   */
  implicit class UserImplicit(user: Option[UserFull]) {
    def idStr: Option[String] = user.map(_.id_str)
    def id: Option[Long] = user.map(_.id)
  }

  /**
   * Map tweet to ModelDatabase
   * @param tweetsFull
   */
  implicit class TweetFullImplicit(tweetsFull: Seq[TweetFull]) {

    /**
     * Get ModelDatabase group by user
     * @param semigroup
     * @return
     */
    def toModelDatabase(implicit semigroup: Semigroup[ModelDatabase]): Seq[ModelDatabase] = tweetsFull
      .flatMap(ModelDatabase.tweetFullToModelDb)
      .groupBy(_.userId)
      .mapValues(_.reduce(semigroup.combine))
      .values
      .toSeq
  }
}
