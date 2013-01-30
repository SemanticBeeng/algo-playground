package interview.sort

object QuickSort {
  def sort[T <% Ordered[T]](array: Array[T]) {
    def exchange(i: Int, j: Int) {
      val v = array(i)
      array(i) = array(j)
      array(j) = v
    }

    def partition(p: Int, r: Int): Int = {
      val pivot = array(r)
      var i = p - 1
      for (j <- p to r-1) {
        if (array(j) <= pivot) {
          i += 1
          exchange(i, j)
        }
      }
      exchange(i+1, r)
      i+1
    }

    def quickSort(p: Int, r: Int) {
      if (r - p < 1) return

      val partitioned = partition(p, r)
      quickSort(p, partitioned - 1)
      quickSort(partitioned + 1, r)
    }

    quickSort(0, array.length - 1)
  }
}