import com.sage.Workflow
import com.sage.request.request.Request

import java.net.URI
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.{HttpClient, HttpRequest, HttpResponse}
import com.sage.request.request.FormRequest
import com.sage.response.Response
import com.sage.dsl.DSL.*

import java.util.concurrent.ConcurrentLinkedQueue
import scala.concurrent.Future
import scala.util.Try

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
  val request = FormRequest(url = "http://www.baidu.com") ~~> log ~~>> Workflow() ~~> log1
  request.onComplete(resTry =>
    if (resTry.isSuccess) {
      println(resTry.get.content)
    } else {
      println("Failed")
    }
  )
  Thread.sleep(500)
}

@main def test3(): Unit = {
  (GET("http://www.baidu.com") ~~>> Workflow()).onComplete(
    x => println(x.get.content)
  )
  Thread.sleep(500)

}

@main def test4(): Unit = {
  val workFlow = Workflow()
  val list = new ConcurrentLinkedQueue[Try[Response]]()
  val t1 = System.currentTimeMillis()
  for (i <- 1 to 5000) {
    val a = POST("http://localhost:9090/pigeon377/114/pigeon/1919/810/ls") ~~>> workFlow
    a.onComplete(resTry =>
      list.add(resTry)
    )
  }
  Thread.sleep(3000)
  var succeed = 0
  list.forEach(x =>
    if (x.isSuccess) {
      succeed += 1
    }
  )
  val t2 = System.currentTimeMillis()
  println((1.0 * (t2 - t1)) / 1000)
  println(1.0 * succeed / list.size())
}

/*6.794
0.815*/