import sbt._
import sbt.Keys._
import scala._
import scala.Some

object InterviewBuild extends Build {

  lazy val buildSettings = Seq(
    organization := "interview",
    version      := "0.1-SNAPSHOT",
    scalaVersion := "2.9.2"
  )
  
  lazy val interview = Project(
    id = "interview",
    base = file("."),
    settings = Project.defaultSettings ++ repositoriesSetting ++ Seq(libraryDependencies ++= Dependencies.root)
  )
  
  // -- Settings

  override lazy val settings = super.settings ++ buildSettings

  lazy val repositoriesSetting = Seq(
    resolvers += "Sonatype Repository" at "http://oss.sonatype.org/content/groups/public/",
    resolvers += "Scala Tools Repository" at "https://oss.sonatype.org/content/groups/scala-tools/",
    resolvers += "JBoss repository" at "http://repository.jboss.org/nexus/content/repositories/",
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    resolvers += "Typesafe Repository ide-2.9" at "http://repo.typesafe.com/typesafe/simple/ide-2.9/",
    resolvers += "Twitter Repository" at "http://maven.twttr.com/",
    resolvers += "Akka Repository" at "http://akka.io/snapshots/"
  )
  }

object Dependencies {
  import Dependency._

  val root = Seq(slf4jApi, logback, scalaz) ++ Seq(Test.scalatest, Test.mockito)
}

object Dependency {

  // Versions

  object V {
    val Slf4j        = "1.6.4"
    val Mockito      = "1.9.0"
    val Scalaz       = "6.0.4"
    val Logback      = "1.0.0"    
	
	  val Scalatest    = "1.8"
  }

  // Compile

  val slf4jApi          = "org.slf4j"                         % "slf4j-api"              % V.Slf4j
  val logback           = "ch.qos.logback"                    % "logback-classic"        % V.Logback
  val scalaz            = "org.scalaz"                       %% "scalaz-core"            % V.Scalaz

  // Provided

  object Provided {

  }

  // Runtime

  object Runtime {

  }

  // Test

  object Test {
    val mockito        = "org.mockito"                 % "mockito-all"             % V.Mockito      % "test" // MIT
    val scalatest      = "org.scalatest"              %% "scalatest"               % V.Scalatest    % "test"
  }
}