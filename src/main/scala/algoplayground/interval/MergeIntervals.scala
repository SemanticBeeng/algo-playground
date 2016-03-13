package algoplayground.interval


object MergeIntervals {

  def merge(left: Seq[Interval], right: Seq[Interval]): Seq[Interval] = {
    val out = Seq.newBuilder[Interval]
    val last: Option[Interval] = (left ++ right).sorted.foldLeft(Option.empty[Interval]) {
      case (None, i) => Some(i)
      case (Some(merged), i) if merged.overlaps(i) => Some(merged.merge(i))
      case (Some(merged), i) if !merged.overlaps(i) => out += merged; Some(i)
    }
    last.foreach(out += _)
    out.result()
  }

}
