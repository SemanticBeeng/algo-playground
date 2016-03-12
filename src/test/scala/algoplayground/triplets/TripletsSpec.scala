package algoplayground.triplets

import org.scalatest.FlatSpec


class SimpleTripletsSpec extends AbstractTripletsSpec(SimpleTriplets)

class RecursiveTripletsSpec extends AbstractTripletsSpec(RecursiveTriplets)

abstract class AbstractTripletsSpec(triplets: Triplets) extends FlatSpec {

  "Triplets" should "find tuplets" in {
    val arr = Array(0, -1, 1, 2, 3, 5)

    val tuplets1 = triplets.tuplets(arr.sorted, 0, arr.length - 1, 0)
    assert(tuplets1 == Seq((-1, 1)))

    val tuplets2 = triplets.tuplets(arr.sorted, 0, arr.length - 1, 3)
    assert(tuplets2 == Seq((0, 3), (1, 2)))
  }

  it should "find triplets" in {
    val arr = Array(0, -1, 1, 2, 3, 5)

    val triplets1 = triplets.triplets(arr.sorted, 0)
    assert(triplets1 == Seq((-1, 0, 1)))

    val triplets2 = triplets.triplets(arr.sorted, 5)
    assert(triplets2 == Seq((-1, 1, 5), (0, 2, 3)))

  }

}
