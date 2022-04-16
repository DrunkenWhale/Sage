package com.sage.dsl

import com.sage.Workflow
import com.sage.request.meta.{RequestArg, RequestHeader}
import com.sage.request.meta.body.FormBody
import com.sage.request.request.{FormRequest, Request}
import com.sage.response.Response

import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object DSL {

  def GET(url: String,
          header: Map[String, String] = Map.empty,
          arg: Map[String, String] = Map.empty): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      arg = RequestArg(arg.toList)
    )
  }

  def POST(url: String,
           body: Map[String, String] = Map.empty,
           header: Map[String, String] = Map.empty): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "POST",
      body = FormBody(body.toList)
    )
  }

  def PUT(url: String,
          body: Map[String, String] = Map.empty,
          header: Map[String, String] = Map.empty,
          arg: Map[String, String] = Map.empty): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "PUT",
      arg = RequestArg(arg.toList),
      body = FormBody(body.toList)
    )
  }

  def DELETE(url: String,
             body: Map[String, String] = Map.empty,
             header: Map[String, String] = Map.empty,
             arg: Map[String, String] = Map.empty): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "DELETE",
      arg = RequestArg(arg.toList),
      body = FormBody(body.toList)
    )
  }


  extension (self: Request) {


    // lambda slot
    // can be used in any place before request entry flow
    def ~~>(lambda: Request => Request): Request = {
      lambda(self)
    }

    def ~~>>(workflow: Workflow): Future[Response] = {
      workflow.executeTask(self)
    }

  }

  extension (self: Future[Response]) {

    def ~~>(lambda: Response => Response): Future[Response] = {
      self.map(lambda)
    }

  }


}
