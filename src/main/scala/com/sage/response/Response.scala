package com.sage.response

private[sage] class Response[T](val statusCode: Int,
                                val headers: Map[String, String],
                                val content: T,
                                val url: String,
                                val version: String) {

}

object Response {

  def apply[T](statusCode: Int,
               headers: Map[String, String],
               content: T,
               url: String,
               version: String): Response[T] =
    new Response(statusCode, headers, content, url, version)

}