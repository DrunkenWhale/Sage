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
  val request = FormRequest(url = "http://www.baidu.com") ~~> Workflow()
  request.onComplete(resTry =>
    if (resTry.isSuccess) {
      println(resTry.get.content)
    } else {
      println("Failed")
    }
  )
}