package com.sage

import com.sage.request.meta.body.{FileBody, FormBody, InputStreamBody}
import com.sage.request.model.Request
import com.sage.response.Response

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.time.Duration
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

private class Workflow {

  private val httpClientBuilder: HttpClient.Builder = HttpClient.newBuilder()

  lazy val httpClient: HttpClient = httpClientBuilder.build()

}

object Workflow {

  extension (self: Workflow) {

    def executeTask(task: Request): Response = {

      val request: HttpRequest = {

        val builder = HttpRequest.newBuilder()
        builder.uri(
          URI.create(s"${task.url}?${task.arg}")
        )

        task.header
            .kvList
            .foreach((k, v) => builder.setHeader(k, v))

        builder.method(
          task.method,
          task.body match {

            case form: FormBody => HttpRequest.BodyPublishers
                .ofString(form.toString)

            case file: FileBody => HttpRequest.BodyPublishers
                .ofFile(file.filePath)

            case input: InputStreamBody => HttpRequest.BodyPublishers
                .ofInputStream(null)
          }
        )
        builder.build()

      }

      val res = self.httpClient.sendAsync(
        request,
        HttpResponse.BodyHandlers.ofString()
      )

      null
    }

  }

}