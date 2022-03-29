package com.sage.request.request

import com.sage.request.meta.body.{FormBody, InputStreamBody}
import com.sage.request.meta.{Arg, Header}

class InputStreamRequest(val url: String,
                         val method: String,
                         val header: Header,
                         val arg: Arg,
                         override val body: InputStreamBody) extends Request {

}