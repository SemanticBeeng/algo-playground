package algoplayground.interval

import java.util.concurrent.atomic.AtomicLong

import scala.util.Try


object MinOverlap {

  val cnt = new AtomicLong(0)

  /**
    * Given a set of ranges:
    * (e.g. S = {(1, 4), (30, 40), (20, 91) ,(8, 10), (6, 7), (3, 9), (9, 12), (11, 14)}.
    * And given a target range R (e.g. R = (3, 13) - meaning the range going from 3 to 13). Write an algorithm to find
    * the smallest set of ranges that covers your target range. All of the ranges in the set must overlap in order
    * to be considered as spanning the entire target range. (In this example, the answer would be {(3, 9), (9, 12), (11, 14)}
    */
  def minOverlap(intervals: Seq[Interval], interval: Interval): Option[Seq[Interval]] = {

    val init = intervals.sorted.dropWhile(!_.overlaps(interval))

    def run(next: Seq[Interval], merged: Interval, history: Seq[Interval]): Seq[Seq[Interval]] = {
      if (merged.contains(interval)) return Seq(history)
      if (next.isEmpty || !next.head.overlaps(merged)) return Seq.empty

      val candidates = next.takeWhile(_.overlaps(merged))
      candidates.zipWithIndex.flatMap { case (i, idx) =>
        run(next.drop(idx + 1), merged.merge(i), history :+ i)
      }
    }

    val startCandidates = init.takeWhile(_.overlaps(interval))
    startCandidates.zipWithIndex.flatMap { case (i, idx) =>
      run(init.drop(idx + 1), i, Seq(i))
    }.sortBy(_.length).headOption
  }

  def greedyMinOverlap(intervals: Seq[Interval], interval: Interval): Option[Seq[Interval]] = {
    val order = implicitly[Ordering[Interval]]
    val init = intervals.sorted.dropWhile(!_.overlaps(interval))

    def run(next: Seq[Interval], merged: Interval, history: Seq[Interval]): Seq[Seq[Interval]] = {
      if (merged.contains(interval)) return Seq(history)
      if (next.isEmpty || !next.head.overlaps(merged)) return Seq.empty

      val (greedy, greedyIdx) = next.takeWhile(i => i.overlaps(merged)).zipWithIndex.maxBy(_._1.to)
      run(next.drop(greedyIdx + 1), merged.merge(greedy), history :+ greedy)
    }

    val (start, startIdx) = init.takeWhile(i => i.overlaps(interval) && order.lt(i, interval)).zipWithIndex.maxBy(_._1.to)
    Try(run(init.drop(startIdx + 1), start, Seq(start)).minBy(_.length)).toOption
  }


}
