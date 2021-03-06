name := "akkaStreamsAPI"

version := "0.1"

scalaVersion := "2.13.5"

val AkkaVersion = "2.6.13"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion % Test
)
