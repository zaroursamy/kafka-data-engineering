package projectapi

import com.redis.RedisClient
import model.sink.ModelDatabase

/**
 * Modelize API Redis calls
 * @tparam T
 */
trait Api[T] {

  def getById(id: String)(implicit r: RedisClient): Option[T]

  def updateById(id: String, t: T)(implicit r: RedisClient): T

}

object Api {

  import com.redis.serialization.Parse.Implicits._
  import model.ProjectMonoids._

  def sum[T](x: T, y: T)(implicit monoid: cats.Monoid[T]): T = monoid.combine(x, y)

  implicit val modelDatabaseApi: Api[ModelDatabase] = new Api[ModelDatabase] {

    /**
     * Get ModelDatabase from Redis
     * @param id
     * @param r
     * @return
     */
    override def getById(id: String)(implicit r: RedisClient): Option[ModelDatabase] = {

      for (
        id ← r.get[String](id)
      ) yield ModelDatabase(
        userId   = id,
        count    = r.get[Long](s"$id.count").getOrElse(0),
        fav      = r.get[Long](s"$id.favs").getOrElse(0),
        hashtags = r.get[Int](s"$id.hashtags").getOrElse(0),
        mentions = r.get[Int](s"$id.mentions").getOrElse(0),
        name     = r.get[String](s"$id.name").getOrElse(""))

    }

    /**
     * Combine actual state with new state and update in Redis
     * @param id
     * @param newModelDatabase
     * @param r
     * @return
     */
    override def updateById(id: String, newModelDatabase: ModelDatabase)(implicit r: RedisClient): ModelDatabase = {

      val currentState: Option[ModelDatabase] = getById(id)

      val newState: ModelDatabase = currentState match {
        case Some(actual) ⇒ sum(actual, newModelDatabase)
        case None         ⇒ newModelDatabase
      }

      r.set(s"$id.count", newState.count)
      r.set(s"$id.favs", newState.fav)
      r.set(s"$id.hashtags", newState.hashtags)
      r.set(s"$id.mentions", newState.mentions)
      r.set(s"$id.name", newState.name)

      newState

    }
  }
}
