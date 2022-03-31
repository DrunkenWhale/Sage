package com.cloves.request.request

import com.cloves.request.meta.body.{FormBody, InputStreamBody}
import com.cloves.request.meta.{RequestArg, RequestHeader}

class InputStreamRequest(val url: String,
                         val method: String,
                         val header: RequestHeader,
                         val arg: RequestArg,
                         override val body: InputStreamBody) extends Request {

}

object InputStreamRequest {

  def apply(url: String,
            method: String = "GET",
            header: RequestHeader = RequestHeader(),
            arg: RequestArg = RequestArg(),
            body: InputStreamBody): InputStreamRequest
  = new InputStreamRequest(url, method, header, arg, body)

}