import com.sage.Workflow
import com.sage.request.request.Request

import java.net.URI
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import com.sage.request.request.FormRequest
import com.sage.response.Response

import scala.concurrent.Future

@main def test1(): Unit = {
  val client = HttpClient
      .newBuilder()
      .build()
  val request = HttpRequest
      .newBuilder()
      .uri(URI.create("https://www.baidu.com"))
      .build()
  val response: HttpResponse[String] = client.send(request, HttpResponse.BodyHandlers.ofString())
  println(response.body())

}

import concurrent.ExecutionContext.Implicits.global

@main def test2(): Unit = {
  val log = (request: Request) => {
    println(s"${request.url} ${request.header} ${request.body} ")
    request
  }
  val log1 = (response: Response) => {
    println(s"${response.header} ${response.content}")
    response
  }
  val request = FormRequest(url = "http://www.baidu.com") ~> log ~~> Workflow() ~> log1
      request.onComplete(resTry =>
        if (resTry.isSuccess) {
          println(resTry.get.content)
        } else {
          println("Failed")
        }
      )
  Thread.sleep(500)
}