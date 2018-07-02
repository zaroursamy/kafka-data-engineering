package validator

import model.source.TweetFull

object TweetValidator {

  /**
   * True if tweet text is in french and contains "mario"
   * @param tweetFull
   * @return
   */
  def isMarioFr(tweetFull: TweetFull): Boolean = tweetFull.text.toLowerCase.contains("mario") && tweetFull.lang.contains("fr")
}
