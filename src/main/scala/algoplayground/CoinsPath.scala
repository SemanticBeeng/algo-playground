package algoplayground

import java.util.concurrent.atomic.AtomicLong

import scala.collection.mutable

object CoinsPath extends App {

  /**
    * Given a matrix where every cell has some number of coins. Count number of ways to reach bottom right
    * from top left with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).
    *
    * Example:
    *
    * Input:  k = 12
    *         mat[][] = { {1, 2, 3},
    *                     {4, 6, 5},
    *                     {3, 2, 1}
    *                   };
    * Output:  2
    * There are two paths with 12 coins
    * 1 -> 2 -> 6 -> 2 -> 1
    * 1 -> 2 -> 3 -> 5 -> 1
    */

  val n = 3
  val k = 12

  val map = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(3, 2, 1)
  )

  val cnt = new AtomicLong(0)

  def findPath(): Seq[Seq[Int]] = {

    val memo = mutable.Map.empty[(Int, Int), Seq[Seq[Int]]]

    def path(row: Int, col: Int): Seq[Seq[Int]] = {
      cnt.incrementAndGet()
      if (row >= n || col >= n) return Seq.empty
      if (row == n - 1 && col == n - 1) return Seq(Seq(map(row)(col)))

      val rightMove = memo.getOrElseUpdate((row, col + 1), path(row, col + 1))
      val downMove = memo.getOrElseUpdate((row + 1, col), path(row + 1, col))
      (rightMove ++ downMove).map(map(row)(col) +: _)
    }

    path(0, 0).map(map(0)(0) +: _)
  }

  findPath().filter(_.sum == k) .foreach(println)
  println(cnt.get)

}
