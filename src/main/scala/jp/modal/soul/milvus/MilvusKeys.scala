package jp.modal.soul.milvus

import sbt._

/**
 * Created by imae on 2016/09/20.
 */
object MilvusKeys extends MilvusKeys

trait MilvusKeys {
  val title = settingKey[String]("title")

  val email = settingKey[String]("email address")

  val description = settingKey[String]("description")

  val url = settingKey[String]("the base hostname & protocol for your site")

  val image = settingKey[String]("image")

  val twitterUsername = settingKey[String]("twitter username")

  val githubUsername = settingKey[String]("github username")


  // pagination setting
  val paginate = settingKey[Int]("paginate")

  val paginationPath = settingKey[String]("page/:num")


}
