package com.cloves

import com.cloves.request.meta.{RequestArg, RequestHeader}
import com.cloves.request.meta.body.FormBody
import com.cloves.request.request.{FormRequest, Request}

package object dsl {
  def GET(url: String, header: Map[String, String], arg: Map[String, String]): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      arg = RequestArg(arg.toList)
    )
  }

  def POST(url: String, body: Map[String, String], header: Map[String, String]): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "POST",
      body = FormBody(body.toList)
    )
  }

  def PUT(url: String, body: Map[String, String], header: Map[String, String], arg: Map[String, String]): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "PUT",
      arg = RequestArg(arg.toList),
      body = FormBody(body.toList)
    )
  }

  def DELETE(url: String, body: Map[String, String], header: Map[String, String], arg: Map[String, String]): Request = {
    FormRequest(
      url = url,
      header = RequestHeader(header.toList),
      method = "DELETE",
      arg = RequestArg(arg.toList),
      body = FormBody(body.toList)
    )
  }
}
