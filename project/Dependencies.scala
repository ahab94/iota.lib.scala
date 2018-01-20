import sbt._

object Dependencies {

  val http = Seq("com.softwaremill.sttp" %% "core" % "1.1.4")

  val json = Seq()

  val misc = Seq()

  val all: Seq[ModuleID] =
    http ++
      json ++
      misc

  val resolvers = Seq(
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  )
}