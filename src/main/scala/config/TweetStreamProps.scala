package config

import org.apache.kafka.common.serialization.Serdes

object TweetStreamProps {

  val STRING_DESERIALIZER: String = Serdes.String().getClass.getName

}