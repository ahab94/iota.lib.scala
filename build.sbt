organization := "ahab94"

name := "iota.lib.scala"

version := "0.1"

scalaVersion := "2.12.4"

coverageEnabled.in(Test, test) := true

organizationHomepage := Some(url("https://github.com/ahab94"))

scalacOptions := Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Dependencies.all

resolvers ++= Dependencies.resolvers