package com.sage.request.model

import com.sage.request.meta.body.FormBody
import com.sage.request.meta.{Arg, Header}

class FileRequest(val url: String,
                  val method: String,
                  val header: Header,
                  val arg: Arg,
                  val body: FormBody) extends Request {

}
