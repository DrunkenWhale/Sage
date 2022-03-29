package com.sage.request.request

import com.sage.request.meta.body.FormBody
import com.sage.request.meta.{RequestArg, RequestHeader}

private class FormRequest(val url: String,
                          val method: String,
                          val header: RequestHeader,
                          val arg: RequestArg,
                          override val body: FormBody) extends Request {

}

object FormRequest {

  def apply(url: String,
            method: String = "GET",
            header: RequestHeader = RequestHeader(),
            arg: RequestArg = RequestArg(),
            body: FormBody = FormBody()): FormRequest
  = new FormRequest(url, method, header, arg, body)

}
