import sbt._

object Dependencies {

  val http = Seq("com.softwaremill.sttp" %% "core" % "1.1.4")

  val iotaLibs = Seq("com.github.iotaledger" % "iota~lib~java" % "0.9.10")

  val json = Seq()

  val all: Seq[ModuleID] =
    http ++
      json ++
      iotaLibs

  val resolvers = Seq(
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
    "jitpack.io" at "https://jitpack.io"
  )
}