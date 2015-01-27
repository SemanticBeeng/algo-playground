package algoplayground.orderstatistics

import org.scalatest.FlatSpec
import util.Random

class NthElementSpec extends FlatSpec {
  "NthElement" should "return order statistics" in {
    (1 to 1) foreach {
      _ =>
        val array = Random.shuffle(1 to 30).toArray
        val n = Random.nextInt(array.length - 1)
        val nth = NthElement.nth(array, n)
        println(array.toSeq)
        val expected = array.sorted.apply(n)

        assert(nth == expected)
    }
  }

}