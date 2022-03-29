package com.sage.request.meta

private[sage] class Arg(val kvList: List[(Key, Value)] = List()) extends KVMeta {

  override def toString: String = super.convertToString(kvList)

}

object Arg {

  def apply(): Arg = new Arg()

  def apply(key: Key, value: Value): Arg = new Arg(List((key, value)))

  def apply(kvSeq: (Key, Value)*): Arg = new Arg(kvSeq.toList)

  extension (arg: Arg) {

    def append(key: Key, value: Value): Arg = new Arg(arg.kvList.appended(key, value))

    def append(kv: (Key, Value)*): Arg = new Arg(arg.kvList.appendedAll(kv))

  }

}