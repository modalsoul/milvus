name := "sbt-test"
version := "0.0.1-SNAPSHOT"

enablePlugins(MilvusPlugin)

lazy val hoge = settingKey[String]("hoge")

hoge in milvus := "hogefuga"