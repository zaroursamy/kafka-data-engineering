package projectapi.redis

import com.redis._
import com.typesafe.config.Config
import config.{ Environment, TypeSafeParams }

object RedisClient {

  /**
   * Get Redis Client params read from application.conf
   * @param conf
   * @param typeSafeParams
   * @return
   */
  def getRedisClient(conf: Config, typeSafeParams: TypeSafeParams): RedisClient = {

    val strEnv: String = Environment.toString(typeSafeParams.env)
    val host = conf.getString(s"$strEnv.redis.url")
    val port = conf.getInt(s"$strEnv.redis.port")

    new RedisClient(host, port)
  }
}
