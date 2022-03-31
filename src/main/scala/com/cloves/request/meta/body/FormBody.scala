package com.cloves.request.meta.body

import com.cloves.request.meta.body.RequestBody
import com.cloves.request.meta.{KVMeta, Key, Value}

private[cloves] class FormBody(val kvList: List[(Key, Value)] = List()) extends RequestBody with KVMeta {

  override def toString: String = super.convertToString(kvList)

}

object FormBody {

  def apply(): FormBody = new FormBody()

  def apply(key: Key, value: Value): FormBody = new FormBody(List((key, value)))

  def apply(kvSeq: (Key, Value)*): FormBody = new FormBody(kvSeq.toList)

  def apply(kvList: List[(Key, Value)]): FormBody = new FormBody(kvList)

  extension (body: FormBody) {

    def append(key: Key, value: Value): FormBody = new FormBody(body.kvList.appended(key, value))

    def append(kv: (Key, Value)*): FormBody = new FormBody(body.kvList.appendedAll(kv))

  }

}
