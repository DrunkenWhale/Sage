package com.sage.request

import com.sage.Workflow

import java.net.http.HttpRequest
import com.sage.request.meta.Header
import com.sage.request.meta.Arg
import com.sage.request.meta.Body

case class Request(header: Header, arg: Arg, body: Body)

object Request {

  extension (self: Request) {


    // lambda slot
    // can be used in any place before request entry flow
    def ~>(lambda: Request => Request): Request = {
      lambda(self)
    }

    def ~>(workflow: Workflow): Unit = {

    }

  }

}
