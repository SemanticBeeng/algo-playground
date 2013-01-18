package interview.sort


object MergeSort {
  def sort[T <% Ordered[T]](array: Array[T]) {
    if (array.length == 0 || array.length == 1) return
    mergeSort(array, 0, array.length - 1)
  }

  private def mergeSort[T <% Ordered[T]](underlying: Array[T], p: Int, r: Int) {
    if (p >= r) {
      return
    }
    else {
      val q = (p + r) / 2
      mergeSort(underlying, p, q)
      mergeSort(underlying, q + 1, r)
      merge(underlying, p, q, r)
    }
  }

  private def merge[T <% Ordered[T]](underlying: Array[T], p: Int, q: Int, r: Int) {
    val left = underlying.slice(p, q+1)
    val right = underlying.slice(q + 1, r+1)

    var li = 0
    var ri = 0

    def leftOption: Option[T] = if (li >= left.length) None else Some(left(li))
    def rightOption: Option[T] = if (ri >= right.length) None else Some(left(ri))

    for (i <- p to r) {
      val min = (leftOption, rightOption) match {
        case (Some(lv), Some(rv)) if (lv <= rv) =>
          li +=1
          lv

        case (Some(lv), Some(rv)) if (rv <= lv) =>
          li += 1
          rv

        case (None, Some(rv)) =>
          ri+=1
          rv

        case (Some(lv), None) =>
          li+=1
          lv
      }

      underlying(i) = min
    }
  }
}