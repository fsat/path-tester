import sbt.Resolver.bintrayRepo
import ByteConversions._

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
  Library.playConductRBundleLib,
  Library.mockitoAll % "test",
  Library.scalaTest % "test"
)

scalariformSettings

routesGenerator := InjectedRoutesGenerator

BundleKeys.bundleConfVersion := BundleConfVersions.V_1_2_0
BundleKeys.compatibilityVersion := "1.0"
BundleKeys.nrOfCpus := 1.0
BundleKeys.memory := 64.MiB
BundleKeys.diskSpace := 35.MB
BundleKeys.roles := Set("web")
javaOptions in Bundle ++= Seq("-Dhttp.address=$PTEST_BIND_IP", "-Dhttp.port=$PTEST_BIND_PORT")
BundleKeys.endpoints := Map(
  "ptest" -> Endpoint("http", 0, "path-tester",
    RequestAcl(
      Http(
        "^/bacon".r -> "/burger",
        "^/tree".r,
        "^/fee/(.*)/fi/(.*)/fo/(.*)/fum$".r -> "/boom/\\1-\\2-\\3/box",
        "^/boom/(.*)/box$".r,
        "/foo" -> "/baz",
        "/baz"
      )
    )
  ),
  "ptunnel" -> Endpoint("tcp", 0, "ptunnel",
    RequestAcl(
      Tcp(
        12101, 3303, 5601
      )
    )
  )
)
