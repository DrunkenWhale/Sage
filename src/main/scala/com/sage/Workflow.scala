package com.sage

import com.sage.request.meta.body.{FileBody, FormBody, InputStreamBody}
import com.sage.request.request.Request
import com.sage.response.Response

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import java.time.Duration
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import scala.jdk.FutureConverters.CompletionStageOps

private class Workflow {

  private val httpClientBuilder: HttpClient.Builder = HttpClient.newBuilder()

  lazy val httpClient: HttpClient = httpClientBuilder.build()

}

object Workflow {

  extension (self: Workflow) {

    def executeTask(task: Request): Future[Response[String]] = {

      val request: HttpRequest = {

        val builder = HttpRequest.newBuilder()

        builder.uri(
          URI.create(s"${task.url}?${task.arg}")
        )

        builder.timeout(Duration.ofMillis(5000))

        task.header
            .kvList
            .foreach((k, v) => builder.header(k, v))

        builder.method(
          task.method,
          task.body match {

            case form: FormBody =>
              builder.header("Content-Type", "application/x-www-form-urlencoded")
              HttpRequest.BodyPublishers
                  .ofString(form.toString)

            case file: FileBody => HttpRequest.BodyPublishers
                .ofFile(file.filePath)

            case input: InputStreamBody => HttpRequest.BodyPublishers
                .ofInputStream(input.inputStreamSupplier)
          }
        )
        builder.build()

      }

      val res = self.httpClient.sendAsync(
        request,
        HttpResponse.BodyHandlers.ofString()
      ).asScala

      res.transform { httpResponseTry =>
        httpResponseTry.map { httpResponse =>
          Response(
            statusCode = httpResponse.statusCode(),
            headers = {
              val headers = httpResponse.headers().map()
              val list: ListBuffer[(String, String)] = ListBuffer.empty
              headers.keySet().forEach(key =>
                list.addOne((key,
                    headers.get(key)
                        .toArray()
                        .mkString(";"))
                )
              )
              list.result().toMap
            },
            content = httpResponse.body(),
            url = httpResponse.uri().toURL.getPath,
            version = httpResponse.version().name()
          )
        }

      }

    }

  }
}