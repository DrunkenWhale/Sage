package com.sage.request.request

import com.sage.Workflow
import com.sage.request.meta.body.RequestBody
import com.sage.request.meta.{RequestArg, RequestHeader}
import com.sage.response.Response

import java.net.http.HttpRequest
import scala.concurrent.Future

trait Request {
  val url: String
  val method: String
  val header: RequestHeader
  val arg: RequestArg
  val body: RequestBody
}

object Request {
  
}
