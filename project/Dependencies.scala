import sbt._

object Dependencies {

  object Consts {
    val STTP_VERSION = "1.1.5"
  }

  val http = Seq("com.softwaremill.sttp" %% "core" % Consts.STTP_VERSION,
    "com.softwaremill.sttp" %% "async-http-client-backend" % Consts.STTP_VERSION,
    "com.softwaremill.sttp" %% "okhttp-backend" % Consts.STTP_VERSION,
    "com.softwaremill.sttp" %% "async-http-client-backend-future" % Consts.STTP_VERSION,
    "com.softwaremill.sttp" %% "akka-http-backend" % Consts.STTP_VERSION
  )
  
  val iotaLibs = Seq("com.github.iotaledger" % "iota~lib~java" % "0.9.10")

  val json = Seq("com.softwaremill.sttp" %% "json4s" % "1.1.4")

  val utils = Seq("com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Runtime
  )

  val all: Seq[ModuleID] =
    http ++
      json ++
      iotaLibs ++
      utils

  val resolvers = Seq(
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
    "jitpack.io" at "https://jitpack.io"
  )
}
