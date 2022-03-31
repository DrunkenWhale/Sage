package com.sage.response

import scala.concurrent.Future

class Response(val statusCode: Int,
               val header: Map[String, String],
               val content: String,
               val url: String,
               val version: String) {

}

object Response {

  def apply(statusCode: Int,
            headers: Map[String, String],
            content: String,
            url: String,
            version: String): Response
  = new Response(statusCode, headers, content, url, version)

}