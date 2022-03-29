package com.sage.request.request

import com.sage.request.meta.body.FormBody
import com.sage.request.meta.{RequestArg, RequestHeader}

class FileRequest(val url: String,
                  val method: String,
                  val header: RequestHeader,
                  val arg: RequestArg,
                  override val body: FormBody) extends Request {

}
