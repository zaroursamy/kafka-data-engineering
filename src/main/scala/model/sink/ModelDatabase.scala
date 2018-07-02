package model.sink

import model.source.{ Entities, Hashtag, TweetFull, UserMention }

case class ModelDatabase(
    userId:   String,
    count:    Long,
    fav:      Long,
    hashtags: Int,
    mentions: Int,
    name:     String)

object ModelDatabase {

  /**
   * Convert TweetFull to ModelDatabse for near real time statistics
   * @param tf
   * @return
   */
  def tweetFullToModelDb(tf: TweetFull): Iterable[ModelDatabase] = {
    val nbFav: Long = tf.favorite_count.getOrElse(0L)

    val nbHashtag: Int = (for (
      e: Entities ← tf.entities;
      hash: Seq[Hashtag] ← e.hashtags
    ) yield hash.size).getOrElse(0)

    val nbMention: Int = (for (
      e: Entities ← tf.entities;
      mention: Seq[UserMention] ← e.user_mentions
    ) yield mention.size).getOrElse(0)

    val screenName: String = tf.user.map(_.screen_name).getOrElse("")

    (for (id ← tf.user.map(_.id_str)) yield ModelDatabase(id, 1L, nbFav, nbHashtag, nbMention, screenName)).toIterable
  }

}