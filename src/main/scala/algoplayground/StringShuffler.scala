package algoplayground

import scala.collection.mutable

object StringShuffler extends App {

  /**
    * Given a string "str" and pair of "N" swapping indices, generate a lexicographically
    * largest string. Swapping indices can be reused any number times.
    *
    * Eg 1)
    *
    * String = "abdc"
    *
    * Indices:
    *
    * (0,3), (2,3)
    *
    * Answer:
    * cdba, cbad, dbac,dbca
    *
    * you should print only "dbca" which is lexicographically largest.
    */

  def maxShuffle(input: String, swaps: Seq[(Int, Int)]): String = {

    var maxStr: String = input
    val checked = mutable.Set.empty[String]

    val ord = implicitly[Ordering[String]]

    def mutations(str: String): Seq[String] = {
      swaps.map { case (l, r) =>
          val lc = str(l)
          val rc = str(r)
          val arr = str.toCharArray
          arr(r) = lc
          arr(l) = rc
          new String(arr)
      }
    }

    def run(str: String): Unit = {
      if (checked.contains(str)) return
      checked.add(str)
      if (ord.gt(str, maxStr)) maxStr = str
      mutations(str).foreach(run)
    }
    run(input)
    maxStr
  }

  def maxShuffle2(input: String, swaps: Seq[(Int, Int)]): String = {
    val connectedComponents: Seq[Set[Int]] =
      swaps.sorted.foldLeft(Seq.empty[Set[Int]]) {
      case (sets, (l, r)) if sets.exists(set => set.contains(l) || set.contains(r)) => sets.map {
        case set if set.contains(l) || set.contains(r) => set + l + r
        case set => set
      }
      case (sets, (l, r)) => sets :+ Set(l, r)
    }

    val arr = input.toCharArray
    connectedComponents.foreach { set =>
      val sortedIdx = set.toSeq.sorted
      val sortedChars = sortedIdx.map(idx => input(idx)).sorted.reverse
      (sortedChars zip sortedIdx).foreach { case (char, idx) =>
        arr(idx) = char
      }
    }

    new String(arr)
  }

  println(maxShuffle("abdc", Seq((0,3), (2,3))))
  println(maxShuffle("acxrabdz", Seq((0,2),(5,7),(2,7),(1,6))))

  println(maxShuffle2("abdc", Seq((0,3), (2,3))))
  println(maxShuffle2("acxrabdz", Seq((0,2),(5,7),(2,7),(1,6))))

}
