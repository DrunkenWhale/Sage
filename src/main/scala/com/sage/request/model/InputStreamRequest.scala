package com.sage.request.model

import com.sage.request.meta.body.FormBody
import com.sage.request.meta.{Arg, Header}

class InputStreamRequest(val url: String,
                         val method: String,
                         val header: Header,
                         val arg: Arg,
                         override val body: s) extends Request {

}

class s extends FormBody