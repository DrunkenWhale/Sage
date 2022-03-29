package com.sage.request.meta.body

import java.io.FileNotFoundException
import java.nio.file.{Files, Path}

private[sage] class FileBody(val filePath: Path) extends Body {

}

object FileBody {
  
  def apply(filePath: String): FileBody = {
    val path = Path.of(java.net.URI.create(filePath))
    if (Files.exists(path)) {
      new FileBody(path)
    } else {
      throw new FileNotFoundException(s"$filePath is not found")
    }
  }
  
}
