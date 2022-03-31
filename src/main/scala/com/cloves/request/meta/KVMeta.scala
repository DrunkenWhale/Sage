package com.cloves.request.meta

private[request] trait KVMeta {
  def convertToString(kvList: List[(Key, Value)]): String = {
    kvList.map((k, v) => s"$k=$v").mkString("&")
  }
}
