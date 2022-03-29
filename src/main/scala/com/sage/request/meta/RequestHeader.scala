package com.sage.request.meta

private[sage] final case class RequestHeader(kvList: List[(Key, Value)] = List())

// unuseful extends
object RequestHeader extends KVMeta {

  def apply(): RequestHeader = new RequestHeader()

  def apply(key: Key, value: Value): RequestHeader = new RequestHeader(List((key, value)))

  def apply(kvSeq: (Key, Value)*): RequestHeader = new RequestHeader(kvSeq.toList)

  extension (header: RequestHeader) {

    def append(key: Key, value: Value): RequestHeader = apply(header.kvList.appended(key, value))

    def append(kv: (Key, Value)*): RequestHeader = apply(header.kvList.appendedAll(kv))

  }

}