package com.sage.request.request

import com.sage.request.meta.body.{FormBody, InputStreamBody}
import com.sage.request.meta.{RequestArg, RequestHeader}

class InputStreamRequest(val url: String,
                         val method: String,
                         val header: RequestHeader,
                         val arg: RequestArg,
                         override val body: InputStreamBody) extends Request {

}