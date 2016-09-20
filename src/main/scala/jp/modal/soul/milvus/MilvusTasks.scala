package jp.modal.soul.milvus

import sbt._
import sbt.Keys._


object MilvusTasks extends MilvusTask with MilvusHelloTask with MilvusServerTask

trait MilvusTask {
  lazy val milvusTask = Def.task {
    val log = streams.value.log
    log.info("Hello Milvus.")
    println(
      """
        |Usage:
        | milvus::<subcommand> [option]
        |
        |Subcommands:
        | server, s     Serve your site locally
        | build, b      Build your site
        | clean         Clean the site (removes site output and metadata file) without building.
        | help          Show the help message, optionally for a given subcommand.
        |
        |Options:
        | server, s
        |   -port, -p [PORT]  Port to listen on
        |
      """.stripMargin)
  }
}

trait MilvusHelloTask {
  lazy val helloTask = Def.task {
    val log = streams.value.log
    log.info("Hello")
    MilvusConfiguration.exe
  }
}

trait MilvusServerTask {
  import sbt.complete.DefaultParsers._

  lazy val serverTask = Def.inputTask {
    val args: Seq[String] = spaceDelimited("<arg>").parsed
    val port = args.applyOrElse(args.indexWhere(_.trim.matches("""-p||-port"""))+1, (_:Int) => "9000")
    val log = streams.value.log
    MilvusServer.execute(port)
  }
}

object MilvusKeys {
  val milvus = taskKey[Unit]("Milvus root task")
  val mlv = taskKey[Unit]("Milvus root task")
  val hello = taskKey[Unit]("say hello")
  val server = inputKey[Unit]("run server")
  val help = taskKey[Unit]("help")
}
