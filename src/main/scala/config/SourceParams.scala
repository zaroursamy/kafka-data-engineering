package config

case class SourceParams(
    env:           String,
    fromBeginning: String) {
  def typeSafeParams = TypeSafeParams(Environment.fromString(env), TypeSafeParams.strToBool(fromBeginning))
}
