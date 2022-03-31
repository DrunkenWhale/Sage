package com.cloves.request.request

import com.cloves.request.meta.body.FileBody
import com.cloves.request.meta.{RequestArg, RequestHeader}

private class FileRequest(val url: String,
                          val method: String,
                          val header: RequestHeader,
                          val arg: RequestArg,
                          override val body: FileBody) extends Request {

}

object FileRequest {
  def apply(url: String,
            method: String = "GET",
            header: RequestHeader = RequestHeader(),
            arg: RequestArg = RequestArg(),
            body: FileBody): FileRequest
  = new FileRequest(url, method, header, arg, body)
}