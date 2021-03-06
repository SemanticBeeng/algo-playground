name := "Algo Playground"

version := "0.0.1"

organization := "algoplayground"

licenses in ThisBuild += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.8"

crossScalaVersions in ThisBuild := Seq("2.10.5", "2.11.8")

scalacOptions += "-deprecation"

scalacOptions += "-feature"

// Resolvers

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

// Test Dependencies

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)



