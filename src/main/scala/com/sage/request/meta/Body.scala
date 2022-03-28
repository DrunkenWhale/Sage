package com.sage.request.meta

private[request] final case class Body(kvList: List[(Key, Value)] = List())

object Body {

  def apply(): Body = new Body()

  def apply(key: Key, value: Value): Body = new Body(List((key, value)))

  def apply(kvSeq: (Key, Value)*): Body = new Body(kvSeq.toList)

  extension (header: Body) {

    def append(key: Key, value: Value): Body = apply(header.kvList.appended(key, value))

    def append(kv: (Key, Value)*): Body = apply(header.kvList.appendedAll(kv))

  }

}