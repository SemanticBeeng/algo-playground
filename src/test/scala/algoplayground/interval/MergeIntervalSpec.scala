package algoplayground.interval

import org.scalatest.FlatSpec


class MergeIntervalSpec extends FlatSpec {

  "MergeInterval" should "work" in {
    val left = Seq((3, 11), (17, 25), (58, 73)).map { case (l, r) => Interval(l, r) }
    val right = Seq((6, 18), (40, 47)).map { case (l, r) => Interval(l, r) }

    val merged = MergeIntervals.merge(left, right)
    assert(merged == Seq((3, 25), (40, 47), (58, 73)).map { case (l, r) => Interval(l, r) })
  }

}
