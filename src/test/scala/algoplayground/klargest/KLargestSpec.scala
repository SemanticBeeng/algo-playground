package algoplayground.klargest

import org.scalatest.FlatSpec

import scala.util.Random


class KLargestSpec extends FlatSpec {

  "K Largest" should "find k largest elements" in {
    val seq = Random.shuffle(1 to 1000).toSeq
    val topK = KLargest.topK(10, seq).sorted
    assert(topK == (991 to 1000))
  }

}
