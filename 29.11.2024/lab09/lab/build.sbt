name := "lab07"
version := "0.0.1"

scalaVersion := "3.3.1"

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-explain",
  "-explain-types",
  "-source:3.3",
  "-encoding", "utf8"
)

libraryDependencies ++= Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.4.11"
)