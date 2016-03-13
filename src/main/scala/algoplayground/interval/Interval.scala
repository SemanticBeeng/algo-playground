package algoplayground.interval


case class Interval(from: Int, to: Int) {
  def overlaps(other: Interval): Boolean = {
    from <= other.to && to >= other.from
  }

  def contains(other: Interval): Boolean = {
    other.from >= from && other.to <= to
  }

  def merge(other: Interval): Interval = {
    require(overlaps(other))
    Interval(Math.min(from, other.from), Math.max(to, other.to))
  }

}

object Interval {

  implicit val intervalOrdering: Ordering[Interval] =
    Ordering.by[Interval, (Int, Int)](i => (i.from, i.to))

}
