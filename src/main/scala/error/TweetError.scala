package error

sealed trait TweetError

object TweetError {
  case class LoadConfigError(msg: String) extends TweetError
  case class ParamsError(msg: String) extends TweetError
}

