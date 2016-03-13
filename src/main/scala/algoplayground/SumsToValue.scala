package algoplayground


object SumsToValue {

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

}
