package algoplayground.interval

import java.util.concurrent.atomic.AtomicLong


object MinOverlap {

  val cnt = new AtomicLong(0)

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

}
