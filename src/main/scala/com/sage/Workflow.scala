package com.sage

import java.net.http.HttpClient

class Workflow {
  val httpClient: HttpClient = HttpClient.newHttpClient()
}

object Workflow {
  extension (self: Workflow) {
    def send(): Unit ={
    }
  }
}