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
    Array(4, 6, 5),
    Array(3, 2, 1)
  )

  def findPath(): Seq[Seq[Int]] = {

    val memo = mutable.Map.empty[(Int, Int, Int), Seq[Seq[Int]]]

    def path(row: Int, col: Int, k: Int): Seq[Seq[Int]] = {
      if (row >= n || col >= n || k <= 0) return Seq.empty
      if (row == n - 1 && col == n - 1 && k == map(row)(col)) return Seq(Seq(map(row)(col)))

      val rightMove = memo.getOrElseUpdate((row, col + 1, k - map(row)(col)), path(row, col + 1, k - map(row)(col)))
      val downMove = memo.getOrElseUpdate((row + 1, col, k - map(row)(col)), path(row + 1, col, k - map(row)(col)))
      (rightMove ++ downMove).map(map(row)(col) +: _)
    }

    path(0, 0, k)
  }

  def countPath(): Int = {

    def count(row: Int, col: Int, k: Int): Int = {
      if (row >= n || col >= n || k <= 0) return 0
      if (row == n - 1 && col == n - 1 && k == map(row)(col)) return 1

      val rightMove = count(row, col + 1, k - map(row)(col))
      val downMove = count(row + 1, col, k - map(row)(col))
      rightMove + downMove
    }
    count(0, 0, k)
  }


  println(countPath())
  findPath().filter(_.sum == k) .foreach(println)

}
