package algoplayground

import java.util.concurrent.atomic.AtomicLong

import scala.collection.mutable

object LongestIncreasingSubseq extends App {

  val cnt = new AtomicLong(0)

  def compute(input: Seq[Int]): Seq[Int] = {
    val memo = mutable.Map.empty[Seq[Int], Seq[Int]]
    def run(seq: Seq[Int], hist: Seq[Int]): Seq[Int] = {
      cnt.incrementAndGet()
      val head = hist.head
      val candidates = seq.zipWithIndex.filter(_._1 >= head)
      if (candidates.isEmpty) return hist
      candidates.map({ case (value, idx) =>
        val key = seq.drop(idx + 1)
        memo.getOrElseUpdate(key, run(key, value +: hist))
      }).maxBy(_.length)
    }
    input.zipWithIndex.map({case (value, idx) =>
      val key = input.drop(idx + 1)
      memo.getOrElseUpdate(key, run(key, Seq(value)))
    }).maxBy(_.length).reverse
  }


  println(compute(Seq(10, 22, 9, 33, 21, 50, 41, 60, 80)))
  println(cnt.get())


}
