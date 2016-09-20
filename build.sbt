name := "milvus"

organization := "jp.modal.soul"

version := "0.1-SNAPSHOT"

scalacOptions ++= Seq("-feature", "-deprecation")

sbtPlugin := true

val testDependencies = Seq(
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc()
)

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "6.25.0",
  "com.typesafe" % "config" % "1.3.0"
)++testDependencies

initialCommands := "import jp.modal.soul.milvus._"

