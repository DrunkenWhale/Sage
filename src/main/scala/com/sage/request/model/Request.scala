package com.sage.request.model

import com.sage.Workflow
import com.sage.request.meta.body.Body
import com.sage.request.meta.{Arg, Header}
import com.sage.response.Response

import java.net.http.HttpRequest

trait Request {
  val url: String
  val method: String
  val header: Header
  val arg: Arg
  val body: Body
}

object Request {

  extension (self: Request) {


    // lambda slot
    // can be used in any place before request entry flow
    def ~>(lambda: Request => Request): Request = {
      lambda(self)
    }

    def ~>(workflow: Workflow): Response = {
      workflow.executeTask(self)
    }

  }

}
