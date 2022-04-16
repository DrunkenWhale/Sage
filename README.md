# Sage

base on `java.net.http`

used by http request

## Send A Get Request

```scala
import com.sage.Workflow
import com.sage.dsl.DSL.{GET, ~~>>}

@main def test3(): Unit = {
  (GET("http://www.baidu.com", header = Map("114" -> "514")) ~~>> Workflow()).onComplete(
    x => println(x.get.content)
  )
  Thread.sleep(500)

}

```

### Send Any Request

```scala
import com.sage.Workflow
import com.sage.request.request.{FormRequest, Request}
import com.sage.response.Response
import com.sage.dsl.DSL.*

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

```