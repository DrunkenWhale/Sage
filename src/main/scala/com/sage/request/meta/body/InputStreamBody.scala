package com.sage.request.meta.body

import java.io.InputStream
import java.util.function.Supplier

private[sage] class InputStreamBody(val inputStreamSupplier: Supplier[InputStream]) extends RequestBody {

}

object InputStreamBody {
  def apply(inputStreamSupplier: Supplier[InputStream]): InputStreamBody = new InputStreamBody(inputStreamSupplier)
}
