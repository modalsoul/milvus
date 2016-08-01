package jp.modal.soul.milvus

import com.twitter.finagle.Http
import com.twitter.finagle.Service
import com.twitter.io.Charsets._
import com.twitter.util.Await
import com.twitter.util.Future
import com.twitter.util.Future
import org.jboss.netty.buffer.ChannelBuffers._
import org.jboss.netty.handler.codec.http.{HttpResponseStatus, DefaultHttpResponse, HttpResponse, HttpRequest}

/**
 * Created by imae on 2016/07/31.
 */
object MilvusServer {
  def execute(port:String) {
    Await.ready(Http.serve(s":$port", new MilvusService()))
  }
}

class MilvusService extends Service[HttpRequest, HttpResponse] {
  override def apply(request:HttpRequest):Future[HttpResponse] = {
    val src = "hoge"
    val response = new DefaultHttpResponse(request.getProtocolVersion, HttpResponseStatus.OK)
    response.setContent(copiedBuffer(src, Utf8))
    Future(response)
  }
}