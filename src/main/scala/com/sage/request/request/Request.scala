package com.sage.request.request

import com.sage.Workflow
import com.sage.request.meta.body.RequestBody
import com.sage.request.meta.{RequestArg, RequestHeader}
import com.sage.response.Response

import java.net.http.HttpRequest
import scala.concurrent.Future

trait Request {
  val url: String
  val method: String
  val header: RequestHeader
  val arg: RequestArg
  val body: RequestBody
}

object Request {

  extension (self: Request) {


    // lambda slot
    // can be used in any place before request entry flow
    def ~>(lambda: Request => Request): Request = {
      lambda(self)
    }

    def ~>(workflow: Workflow): Future[Response[String]] = {
      workflow.executeTask(self)
    }

  }

}
