package com.sage

import com.sage.request.Request
import com.sage.response.Response

import java.net.http.HttpClient
import java.time.Duration
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Workflow {
  val httpClient: HttpClient = HttpClient
      .newBuilder()
      .connectTimeout(Duration.ofMillis(3000))
      .build()

  val tasks: ListBuffer[Future[Response]] = ListBuffer.empty

}

object Workflow {

  extension (self: Workflow) {

    def addTask(task: Future[Request]): Workflow = {
      self.tasks.addOne(task)
      self
    }

  }

}