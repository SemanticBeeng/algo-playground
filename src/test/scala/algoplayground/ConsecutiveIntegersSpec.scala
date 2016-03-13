package algoplayground

import org.scalatest.FlatSpec


class ConsecutiveIntegersSpec extends FlatSpec {

  "ConsecutiveIntegers" should "find longest sub-seq length" in {
    assert(1 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 0, 4, 2, 6)))
    assert(2 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 2, 4, 2, 6)))
    assert(3 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 2, 3, 2, 6)))
  }

  it should "find longest sub-seq" in {
    assert(Seq(1) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 0, 4, 2, 6)).toSeq)
    assert(Seq(1, 2) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 2, 4, 2, 6)).toSeq)
    assert(Seq(1, 2, 3) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 2, 3, 2, 6)).toSeq)
  }

}
