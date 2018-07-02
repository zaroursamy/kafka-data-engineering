package config

import java.util.{ Properties, UUID }
import com.typesafe.config.Config
import error.TweetError
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.streams.StreamsConfig
import scala.collection.JavaConverters._
import scala.util.{ Failure, Success, Try }

case class KafkaConfig(
    brokers: List[String],
    groupId: String) {

  def brokerString: String = brokers.mkString(",")

  override def toString: String = s"brokers=$brokerString, groupId=$groupId"
}

object KafkaConfig {

  /**
   * Get brokers from application.conf
   *
   * @param conf
   * @param params
   * @return
   */
  private def getBrokersList(conf: Config, params: TypeSafeParams): Either[TweetError, List[String]] = Try {
    val strEnv = Environment.toString(params.env)
    conf.getStringList(s"$strEnv.kafka.brokers").asScala.toList
  } match {
    case Success(x) ⇒ Right(x)
    case Failure(f) ⇒ Left(TweetError.LoadConfigError(f.getMessage))
  }

  /**
   * Get brokers and groupId
   *
   * @param params
   * @param conf
   * @return
   */
  def genKafkaConf(params: TypeSafeParams, conf: Config): KafkaConfig = {

    val strEnv = Environment.toString(params.env)

    val confGid = conf.getString(s"$strEnv.kafka.groupid")

    //FIXME Should return an error if isLeft
    val brokers = getBrokersList(conf, params).fold(_ ⇒ List("localhost:9092"), identity)

    val gid = if (params.fromBeginning) s"$confGid-${UUID.randomUUID().toString}" else confGid

    KafkaConfig(brokers, gid)
  }

  /**
   * Properties for a String,String Streams
   *
   * @param kafkaConfig
   * @return
   */
  def getMarioStreamsProps(kafkaConfig: KafkaConfig): (Properties, Map[String, String]) = {

    import kafkaConfig._
    val props = new Properties()

    val mapProps = Map(
      StreamsConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers.mkString(","),
      StreamsConfig.APPLICATION_ID_CONFIG -> "streams-mario-homework",
      StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG -> TweetStreamProps.STRING_DESERIALIZER,
      StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG -> TweetStreamProps.STRING_DESERIALIZER)

    mapProps.foreach { case (k, v) ⇒ props.put(k, v) }

    (props, mapProps)
  }

  /**
   * Properties for a Kafka consumer
   * @param kafkaConfig
   * @param keySerde
   * @param valueSerde
   * @return
   */
  def getConsumerProps(kafkaConfig: KafkaConfig)(keySerde: String, valueSerde: String): (Properties, Map[String, String]) = {
    import kafkaConfig._
    val props = new Properties()

    val mapProps = Map(
      ConsumerConfig.FETCH_MIN_BYTES_CONFIG -> "1", // Default 1: ie every time a byte of message is produced, it is consumed
      ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG -> "10000",
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers.mkString(","),
      ConsumerConfig.GROUP_ID_CONFIG -> groupId,
      ConsumerConfig.AUTO_OFFSET_RESET_CONFIG -> "earliest",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> valueSerde,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> keySerde)

    mapProps.foreach { case (k, v) ⇒ props.put(k, v) }

    (props, mapProps)
  }

}