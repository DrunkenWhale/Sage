package com.cloves.request.meta.body

import java.io.FileNotFoundException
import java.nio.file.{Files, Path}

private[cloves] class FileBody(val filePath: Path) extends RequestBody {

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
