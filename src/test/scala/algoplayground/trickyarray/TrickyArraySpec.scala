package algoplayground.trickyarray

import org.scalatest.FlatSpec

class TrickyArraySpec extends FlatSpec {

  "A Tricky Array" should "reverse underlying array" in {
    val array = new TrickyArray(Array(0, 1, 2, 3))
    array.reverseArray(1)
    assert(array.underlying.toList == Array(1, 0, 2, 3).toList)
  }

  it should "return index" in {
    val array = new TrickyArray(Array(0, 1, 2, 3))
    assert(array.getIndexOfNthLargest(1) == 3) // Index of '3'
    assert(array.getIndexOfNthLargest(2) == 2) // Index of '2'
  }
}