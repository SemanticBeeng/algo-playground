package algoplayground.triplets


trait Triplets {

  def tuplets(arr: Array[Int], from: Int, to: Int, sum: Int): Seq[(Int, Int)]

  def triplets(arr: Array[Int], sum: Int): Seq[(Int, Int, Int)]

}

object RecursiveTriplets extends Triplets with App {
  def tuplets(arr: Array[Int], from: Int, to: Int, sum: Int): Seq[(Int, Int)] = {
    if (from >= to) Seq.empty
    else arr(from) + arr(to) match {
      case s if s == sum => Seq((arr(from), arr(to))) ++ tuplets(arr, from + 1, to, sum)
      case s if s < sum  => tuplets(arr, from + 1, to, sum)
      case _             => tuplets(arr, from, to - 1, sum)
    }
  }

  def triplets(arr: Array[Int], sum: Int): Seq[(Int, Int, Int)] = {
    if (arr.length == 2) return Seq.empty

    tuplets(arr, 1, arr.length - 1, sum - arr(0)).map { case (l, r) => (arr(0), l, r) } ++ triplets(arr.tail, sum)
  }

  println(triplets(Array(3, 3, 3, 4, 4, 1, 0, 9, 0, 7).sorted, 9))
}

object SimpleTriplets extends Triplets with App {

  /**
    * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
    * If there is such a triplet present in array, then print the triplet and return true.
    * Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24,
    * then there is a triplet (12, 3 and 9) present in array whose sum is 24.
    */

  def tuplets(arr: Array[Int], from: Int, to: Int, sum: Int): Seq[(Int, Int)] = {
    var l: Int = from
    var r: Int = to
    val out = Seq.newBuilder[(Int, Int)]
    while (l < r) {
      val s = arr(l) + arr(r)
      if (s == sum) {
        out += arr(l) -> arr(r)
        l += 1
      } else if (s < sum) {
        l += 1
      } else if (s > sum) {
        r -= 1
      }
    }
    out.result()
  }

  val arr = Array(1, 2, 5, -2, 6, 7, 4, 3, 9).sorted
  println(arr.toSeq)
  print(tuplets(arr, 0, arr.length - 1, 7))

  def triplets(arr: Array[Int], sum: Int): Seq[(Int, Int, Int)] = {
    val out = Seq.newBuilder[(Int, Int, Int)]
    (0 to (arr.length - 3)).foreach { i =>
      val tpls = tuplets(arr, i + 1, arr.length - 1, sum - arr(i))
      tpls.foreach { case (v1, v2) => out += ((arr(i), v1, v2))}
    }
    out.result()
  }

}
