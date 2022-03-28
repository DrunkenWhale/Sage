package com.sage.request

import com.sun.net.httpserver.Headers

private final case class Header(kvList: List[(Key, Value)] = List())

object Header {

  def apply(): Header = new Header()

  def apply(key: Key, value: Value): Header = new Header(List((key, value)))

  def apply(kvSeq: (Key, Value)*): Header = new Header(kvSeq.toList)

  extension (header: Header) {

    def append(key: Key, value: Value): Header = apply(header.kvList.appended(key, value))
    
    def append(kv: (Key, Value)*): Header = apply(header.kvList.appendedAll(kv))

  }

}