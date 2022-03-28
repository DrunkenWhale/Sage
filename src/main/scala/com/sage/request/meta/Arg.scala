package com.sage.request.meta

private[request] final case class Arg(kvList: List[(Key, Value)] = List())

object Arg {

  def apply(): Arg = new Arg()

  def apply(key: Key, value: Value): Arg = new Arg(List((key, value)))

  def apply(kvSeq: (Key, Value)*): Arg = new Arg(kvSeq.toList)

  extension (header: Arg) {

    def append(key: Key, value: Value): Arg = apply(header.kvList.appended(key, value))

    def append(kv: (Key, Value)*): Arg = apply(header.kvList.appendedAll(kv))

  }

}