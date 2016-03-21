import sbt.Resolver.bintrayRepo

enablePlugins(JavaAppPackaging, PlayScala)

name := "path-tester"

resolvers += bintrayRepo("typesafe", "maven-releases")

version := "0.1.0"

scalaVersion := Version.scala

scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

libraryDependencies ++= List(
  Library.playWs,
  Library.mockitoAll % "test",
  Library.scalaTest % "test"
)

scalariformSettings

routesGenerator := InjectedRoutesGenerator

