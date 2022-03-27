import java.net.URI
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.{HttpClient, HttpRequest, HttpResponse}

@main def test1() = {
  val client = HttpClient.newBuilder()
      .build()
  val request = HttpRequest.newBuilder().uri(URI.create("http://www.baidu.com")).build()
  val response = client.send(request,HttpResponse.BodyHandlers.ofString())
  println(response.toString)
}
