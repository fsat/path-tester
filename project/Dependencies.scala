import sbt._
import sbt.Resolver.bintrayRepo

object Version {
  val play                   = "2.4.0"
  val conductRBundleLib      = "1.4.0"
  val scala                  = "2.11.6"
  val scalaTest              = "2.2.4"
  val mockito                = "1.9.5"
}

object Library {
  val playJson                = "com.typesafe.play"      %% "play-json"                            % Version.play
  val playWs                  = "com.typesafe.play"      %% "play-ws"                              % Version.play
  val playConductRBundleLib   = "com.typesafe.conductr"  %% "play24-conductr-bundle-lib"           % Version.conductRBundleLib
  val mockitoAll              = "org.mockito"            %  "mockito-all"                          % Version.mockito
  val scalaTest               = "org.scalatest"          %% "scalatest"                            % Version.scalaTest
}

object Resolver {
  val typesafeReleases = "typesafe-releases"     at "http://repo.typesafe.com/typesafe/maven-releases"
}
