package algoplayground.interval

import org.scalatest.FlatSpec


class MinOverlapSpec extends FlatSpec {

  /**
    * Given a set of ranges:
(e.g. S = {(1, 4), (30, 40), (20, 91) ,(8, 10), (6, 7), (3, 9), (9, 12), (11, 14)}.
And given a target range R (e.g. R = (3, 13) - meaning the range going from 3 to 13). Write an algorithm to find
  the smallest set of ranges that covers your target range. All of the ranges in the set must overlap in order
  to be considered as spanning the entire target range. (In this example, the answer would be {(3, 9), (9, 12), (11, 14)}.


    */
  "MinOverlap" should "work" in {
    val intervals = Seq((1, 4), (30, 40), (20, 91) ,(8, 10), (6, 7), (3, 9), (9, 12), (11, 14)).map { case (l, r) => Interval(l, r)}
    val interval = Interval(3, 13)
    val set = MinOverlap.greedyMinOverlap(intervals, interval)
    assert(set.isDefined)
    assert(set.get == Seq((3, 9), (9, 12), (11, 14)).map { case (l, r) => Interval(l, r) })
  }

}
