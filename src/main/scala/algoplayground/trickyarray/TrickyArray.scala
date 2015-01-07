package algoplayground.trickyarray

/**
 * http://www.careercup.com/question?id=14970662
 *
 * For a given array size is know but elements using index is not accessible.
 * Two given functions are below:
 * *
 * 1. getIndexOfNthLargest(int n)	// returns the index of nth largest number.
 *                                // Like for n=1 the index of largest element will be returned,
 *                                // for n=2 the index of 2nd largest number will be returned.
 * 2. reverseArray(int i)	        // reverse the elements of the array from index 0 to i
 *
 * How to sort the array in place?
 */

object TrickyArray {
  def apply[T <% Ordered[T]](underlying: Array[T]) = new TrickyArray(underlying)
}

class TrickyArray[T <% Ordered[T]](private[trickyarray] val underlying: Array[T]) {
  val length = underlying.length

  /**
   * Reverse the elements of the array from index 0 to i
   *
   * @param i index
   */
  def reverseArray(i: Int) {
    for (j <- 0 to i / 2) {
      val v = underlying(i - j)
      underlying(i - j) = underlying(j)
      underlying(j) = v
    }
  }

  /**
   * Returns the index of nth largest number.
   * Like for n=1 the index of largest element will be returned,
   * for n=2 the index of 2nd largest number will be returned.
   *
   * @param n index
   * @return index of nth largest number
   */
  def getIndexOfNthLargest(n: Int) = {
    val sorted = underlying.sorted.reverse
    val nth = sorted(n - 1)
    underlying.indexOf(nth)
  }

  override def toString = underlying.toList.toString()
}