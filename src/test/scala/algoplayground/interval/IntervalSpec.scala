package algoplayground.interval

import org.scalatest.FlatSpec


class IntervalSpec extends FlatSpec {

  "Interval" should "compute overlaps" in {
    assert(Interval(1, 10).overlaps(Interval(5, 11)))
    assert(Interval(1, 10).merge(Interval(5, 11)) == Interval(1, 11))
  }

}
