import sbt._

object Dependencies {

  val http = Seq()

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
