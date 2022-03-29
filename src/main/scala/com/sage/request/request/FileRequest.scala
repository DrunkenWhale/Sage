package com.sage.request.request

import com.sage.request.meta.body.FormBody
import com.sage.request.meta.{Arg, Header}

class FileRequest(val url: String,
                  val method: String,
                  val header: Header,
                  val arg: Arg,
                  override val body: FormBody) extends Request {

}
