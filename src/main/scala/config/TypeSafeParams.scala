package config

import caseapp.CaseApp
import config.Environment.Local
import error.TweetError

case class TypeSafeParams(
    env:           Environment,
    fromBeginning: Boolean)

object TypeSafeParams {

  def strToBool(str: String): Boolean = if (str == "true") true else false

  /**
   * Parse program arguments or get an error
   * @param args
   * @return
   */
  private def getParamsOrError(args: Array[String]): Either[TweetError, TypeSafeParams] = CaseApp.parse[SourceParams](args).right.e match {
    case Right((p: SourceParams, _)) ⇒ Right(p.typeSafeParams)
    case _                           ⇒ Left(TweetError.ParamsError(s"Cannot parse: ${args.mkString(", ")}"))
  }

  /**
   * If error in parsing, run in localhost from last offset
   * @param args
   * @return
   */
  def getParams(args: Array[String]): TypeSafeParams = getParamsOrError(args).fold(_ ⇒ TypeSafeParams(Local, fromBeginning = false), identity)

}