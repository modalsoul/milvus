package jp.modal.soul.milvus

import sbt._
import sbt.Keys._


/**
 * Created by imae on 2016/07/31.
 */

object MilvusPlugin extends AutoPlugin {
  val autoImport = MilvusKeys

  import autoImport._

  import MilvusTasks._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
      milvus <<= milvusTask,
      mlv <<= milvusTask,
      help in milvus <<= milvusTask,
      help in mlv <<= milvusTask,
      server in milvus <<= serverTask,
      server in mlv <<= serverTask,
      hello in mlv <<= helloTask,
      hello in milvus <<= helloTask
    )

}
