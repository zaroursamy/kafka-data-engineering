package config

sealed trait Environment

object Environment {

  case object Local extends Environment

  case object ClusterPoc extends Environment

  case object ClusterProd extends Environment

  def fromString(str: String): Environment = str match {
    case "clusterprod" ⇒ ClusterProd
    case "local"       ⇒ Local
  }

  def toString(environment: Environment): String = environment.toString.toLowerCase()

}