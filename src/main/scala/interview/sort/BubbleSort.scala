package interview.sort

object BubbleSort {
  def sort[T <% Ordered[T]](array: Array[T]) {
    if (array.length == 0 || array.length == 1) return

    for (j <- 0 to array.length - 1) {
      for (i <- 0 to j) {
        if (array(i) > array(j)) {
          val v = array(i)
          array(i) = array(j)
          array(j) = v
        }
      }
    }
  }
}