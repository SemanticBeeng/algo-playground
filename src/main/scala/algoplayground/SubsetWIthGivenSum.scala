package algoplayground

import scala.collection.mutable


object SubsetWIthGivenSum extends App {

  /**
    * On a given array with N numbers, find subset of size M (exactly M elements) that equal to SUM.
    */

  def subset(ARR: Seq[Int], M: Int, SUM: Int): Seq[Seq[Int]] = {

    if (M > ARR.length) return Seq.empty

    val memo = mutable.Map.empty[(Seq[Int], Int, Int), Seq[Seq[Int]]]

    def run(arr: Seq[Int], m: Int, sum: Int): Seq[Seq[Int]] = memo.getOrElseUpdate((arr, m, sum), {
      if (arr.isEmpty) return Seq.empty

      val head = arr.head

      if (m == 1 && sum == head) return Seq(Seq(head))
      if (m == 1 && sum != head) return Seq.empty

      (1 until arr.length)
        .flatMap(i => run(arr.drop(i), m - 1, sum - head))
        .toSeq
        .map(head +: _)
    })

    (0 until ARR.length).flatMap(i => run(ARR.drop(i), M, SUM)).toSeq
  }

  def countSubset(ARR: Seq[Int], M: Int, SUM: Int): Int = {
    if (M > ARR.length) return 0

    val memo = mutable.Map.empty[(Seq[Int], Int, Int), Int]

    def run(arr: Seq[Int], m: Int, sum: Int): Int = memo.getOrElseUpdate((arr, m, sum), {
      if (arr.isEmpty) return 0
      if (m == 1 && sum == arr.head) return 1
      if (m == 1 && sum != arr.head) return 0
      (1 until arr.length).map(i => run(arr.drop(i), m - 1, sum - arr.head)).sum
    })

    (0 until ARR.length).map(i => run(ARR.drop(i), M, SUM)).sum
  }

  println(subset(Seq(3, 3, 3, 4, 4, 1, 0, 9, 0, 7), 3, 9))
  println(countSubset(Seq(3, 3, 3, 4, 4, 1, 0, 9, 0, 7), 3, 9))

}
