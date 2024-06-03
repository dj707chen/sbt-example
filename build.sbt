name := "sbt-example"
organization := "org.scalamacros"
version := "2.0.1"

ThisBuild / scalaVersion := "2.13.14"

// this line is not valid in Scala 2.13 due to <<=, migrate according to https://www.scala-sbt.org/0.13/docs/Migrating-from-sbt-012x.html
//run <<= run in Compile in core

// alias is the way to go, now you can do: sbt runMy
addCommandAlias("runMy", "core / Compile / run")

lazy val macros = project in file("macros") settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = project in file("core") dependsOn macros
