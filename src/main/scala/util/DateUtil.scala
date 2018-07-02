package util

import java.text.SimpleDateFormat
import java.util.{ Date, Locale }
import scala.util.Try

object DateUtil {

  /**
   * Change date format of tweets to yyyy/MM/dd
   * @param str
   * @return
   */
  def convertTweetCreatedAt(str: String): Option[String] = {

    val sf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH)
    sf.setLenient(true)
    val dt: Date = sf.parse(str)

    val formatter = new SimpleDateFormat("yyyy/MM/dd")
    Try(formatter.format(dt)).toOption

  }
}
