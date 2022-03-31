package com.cloves.request.meta

private[cloves] class RequestArg(val kvList: List[(Key, Value)] = List()) extends KVMeta {

  override def toString: String = super.convertToString(kvList)

}

object RequestArg {

  def apply(): RequestArg = new RequestArg()

  def apply(key: Key, value: Value): RequestArg = new RequestArg(List((key, value)))

  def apply(kvSeq: (Key, Value)*): RequestArg = new RequestArg(kvSeq.toList)

  def apply(kvSeq: List[(Key, Value)]): RequestArg = new RequestArg(kvSeq)

  extension (arg: RequestArg) {

    def append(key: Key, value: Value): RequestArg = new RequestArg(arg.kvList.appended(key, value))

    def append(kv: (Key, Value)*): RequestArg = new RequestArg(arg.kvList.appendedAll(kv))

  }

}