import sbt._
import sbt.Keys._
import scala._
import scala.Some

object InterviewBuild extends Build {

  lazy val buildSettings = Seq(
    organization := "interview",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.10.0"
  )

  lazy val root = Project("interview", file("."),
    settings = Project.defaultSettings ++ repositoriesSetting ++
      Seq(libraryDependencies ++= Dependencies.root) ++
      Seq(libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _))
  )

  // -- Settings

  override lazy val settings = super.settings ++ buildSettings

  lazy val repositoriesSetting = Seq(
    resolvers += "Sonatype Repository" at "http://oss.sonatype.org/content/groups/public/"
  )
}

object Dependencies {

  import Dependency._

  val root = Seq(slf4jApi, logback, scalaz) ++ Seq(Test.scalatest, Test.mockito)
}

object Dependency {

  // Versions

  object V {
    val Slf4j = "1.6.4"
    val Mockito = "1.9.0"
    val Scalaz = "6.0.4"
    val Logback = "1.0.0"

    val Scalatest = "1.9.1"
  }

  // Compile

  val slf4jApi = "org.slf4j" % "slf4j-api" % V.Slf4j
  val logback = "ch.qos.logback" % "logback-classic" % V.Logback
  val scalaz = "org.scalaz" %% "scalaz-core" % V.Scalaz

  // Provided

  object Provided {

  }

  // Runtime

  object Runtime {

  }

  // Test

  object Test {
    val mockito = "org.mockito" % "mockito-all" % V.Mockito % "test"
    // MIT
    val scalatest = "org.scalatest" %% "scalatest" % V.Scalatest % "test"
  }
}