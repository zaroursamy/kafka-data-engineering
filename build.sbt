import scalariform.formatter.preferences._

name := "homework-tweets"

version := "0.1"

scalaVersion := "2.12.6"

enablePlugins(PackPlugin)

val kafkaV = "1.0.0"
val circeVersion = "0.8.0"
val kafka_streams_scala_version = "0.1.0"
val jacksonV = "2.8.8"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % kafkaV,
  "org.apache.kafka" % "kafka-streams" % kafkaV,
  "com.lightbend" %% "kafka-streams-scala" % kafka_streams_scala_version,
  "com.typesafe" % "config" % "1.3.2",
  "com.github.alexarchambault" %% "case-app" % "2.0.0-M3",
  "io.spray" %% "spray-json" % "1.3.3",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonV,
  "net.debasishg" %% "redisclient" % "3.7",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
) ++ Seq(
  "circe-core",
  "circe-optics",
  "circe-generic",
  "circe-parser",
  "circe-generic-extras").map(x => "io.circe" %% x % circeVersion)

dependencyOverrides ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonV
)

packResourceDir ++= Map(baseDirectory.value / "src/main/bin" -> "bin", baseDirectory.value / "src/main/resources" -> "conf")

packGenerateWindowsBatFile := false

scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignArguments, true)
  .setPreference(AlignParameters, true)
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(RewriteArrowSymbols, true)