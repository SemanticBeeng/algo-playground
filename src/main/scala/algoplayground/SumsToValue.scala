package algoplayground


object SumsToValue extends App {

  def sumsToValue[T : Ordering](arr: Array[T], value: T, plus: (T, T) => T): Seq[(T, T)] = {

    val ordering = implicitly[Ordering[T]]
    val sorted = arr.sorted

    var l: Int = 0
    var r: Int = arr.length - 1

    val out = Seq.newBuilder[(T, T)]

    while (l < r) {
      val sum = plus(sorted(l), sorted(r))
      if (ordering.equiv(sum, value)) {
        out += sorted(l) -> sorted(r)
        l += 1
      } else if (ordering.gt(sum, value)) {
        r -= 1
      } else if (ordering.lt(sum, value)) {
        l += 1
      }
    }

    out.result()
  }

  val arr = Array[(Int, Int)]((1, 2), (5, 6), (3, 4), (3, 3), (1, 5), (5, 1), (5, 4))
  val out = SumsToValue.sumsToValue[(Int, Int)](arr, (6, 6), (l, r) => (l._1 + r._1, l._2 + r._2))
  assert(out == Seq( ((1, 2), (5, 4)), ((1, 5), (5, 1)) ))

}
