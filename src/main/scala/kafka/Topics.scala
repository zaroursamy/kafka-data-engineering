package kafka

import com.typesafe.config.Config
import config.{ Environment, TypeSafeParams }

object Topics {

  /**
   * Get input topic
   * @param conf
   * @param typeSafeParams
   * @return
   */
  def getInputTopic(conf: Config, typeSafeParams: TypeSafeParams): String = {
    val strEnv = Environment.toString(typeSafeParams.env)
    conf.getString(s"$strEnv.kafka.topic")
  }

  /**
   * Get marioFr topic
   * @param conf
   * @param typeSafeParams
   * @return
   */
  def getOutputMarioFrTopic(conf: Config, typeSafeParams: TypeSafeParams): String = {
    val strEnv = Environment.toString(typeSafeParams.env)
    conf.getString(s"$strEnv.kafka.topicmariofr")
  }
}
