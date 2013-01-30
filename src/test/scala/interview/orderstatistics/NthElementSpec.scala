package interview.orderstatistics

import org.scalatest.FlatSpec
import util.Random

class NthElementSpec extends FlatSpec {
  "NthElement" should "return order statistics" in {
    (1 to 1000) foreach {
      _ =>
        val array = (1 to 100).map(_ => Random.nextInt(100)).toArray
        val n = Random.nextInt(array.length - 1)
        val nth = NthElement.nth(array, n)
        val expected = array.sorted.apply(n)

        assert(nth == expected)
    }
  }

}