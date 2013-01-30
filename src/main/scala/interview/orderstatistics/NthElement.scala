package interview.orderstatistics

import util.Random
import annotation.tailrec

object NthElement {
  def nth[T <% Ordered[T]](array: Array[T], n: Int): T = {

    def swap(i: Int, j: Int) {
      val v = array(i)
      array(i) = array(j)
      array(j) = v
    }

    def partition(p: Int, r: Int): Int = {
      if (p == r) return 0

      val idx = p + Random.nextInt(r - p + 1)
      swap(idx, r)
      val pivot = array(r)

      var i = p - 1
      for (j <- p to r - 1) {
        if (array(j) <= pivot) {
          i += 1
          swap(i, j)
        }
      }
      swap(i + 1, r)
      (i + 1) - p
    }

    @tailrec def nthInternal(p: Int, r: Int, n: Int): T = {
      val q = partition(p, r)
      if (q == n) array(p + q)
      else if (q > n) nthInternal(p, p + q - 1, n)
      else nthInternal(p + q + 1, r, n - q - 1)
    }

    nthInternal(0, array.length - 1, n)
  }


}