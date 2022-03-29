package com.sage.request.meta.body

import java.io.InputStream
import java.util.function.Supplier

private[sage] class InputStreamBody(val inputStreamSupplier: Supplier[InputStream]) extends Body {

}

object InputStreamBody {
  def apply(inputStreamSupplier: Supplier[InputStream]): InputStreamBody = new InputStreamBody(inputStreamSupplier)
}
