name := "sbt-example"
organization := "org.scalamacros"
version := "2.0.0"

ThisBuild / crossScalaVersions := Seq("2.13.14", "2.12.19", "2.11.12")
ThisBuild / scalaVersion := crossScalaVersions.value.head

run := (core / Compile / run).evaluated

lazy val macros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")) dependsOn macros
