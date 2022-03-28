import java.net.URI
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.{HttpClient, HttpRequest, HttpResponse}

@main def test1(): Unit = {
  val client = HttpClient
      .newBuilder()
      .build()
  val request = HttpRequest
      .newBuilder()
      .uri(URI.create("https://www.baidu.com"))
      .build()
  val response:HttpResponse[String] = client.send(request, HttpResponse.BodyHandlers.ofString())
  println(response.body())

}
