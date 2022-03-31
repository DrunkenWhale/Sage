package com.sage.request.meta

private[request] trait KVMeta {
  def convertToString(kvList: List[(Key, Value)]): String = {
    kvList.map((k, v) => s"$k=$v").mkString("&")
  }
}
