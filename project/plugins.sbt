import sbt.Resolver.bintrayRepo

resolvers += bintrayRepo("typesafe", "maven-releases")

addSbtPlugin("com.typesafe.play"     % "sbt-plugin"            % "2.4.0")
addSbtPlugin("com.typesafe.sbt"      % "sbt-scalariform"       % "1.3.0")
addSbtPlugin("com.lightbend.conductr" % "sbt-conductr"        % "2.2.2")
