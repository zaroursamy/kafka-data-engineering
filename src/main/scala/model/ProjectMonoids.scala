package model

import cats.kernel.Monoid
import model.sink.ModelDatabase

object ProjectMonoids {

  implicit val monoidDatabase: Monoid[ModelDatabase] = new cats.Monoid[ModelDatabase] {
    override def combine(x: ModelDatabase, y: ModelDatabase): ModelDatabase = ModelDatabase(
      x.userId,
      x.count + y.count,
      x.fav + y.fav,
      x.hashtags + y.hashtags,
      x.mentions + y.mentions,
      if (x.name.isEmpty) y.name else x.name)

    override def empty: ModelDatabase = ModelDatabase("", 0L, 0L, 0, 0, "")
  }
}
