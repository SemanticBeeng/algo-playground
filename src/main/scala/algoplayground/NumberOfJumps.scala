package algoplayground

import scala.collection.mutable

object NumberOfJumps extends App {

  /**
    * Given an array of integers where each element represents the max number of steps that can be made
    * forward from that element. Write a function to return the minimum number of jumps
    * to reach the end of the array (starting from the first element). If an element is 0,
    * then cannot move through that element.
    *
    * Example:
    * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
    * Output: 3 (1-> 3 -> 8 ->9)
    * First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
    */

  def jumps(input: Seq[Int]): Int = {
    val memo = mutable.Map.empty[Int, Int]
    def run(arr: Seq[Int], startIdx: Int): Int = {
      if (arr.isEmpty) return 0
      if (arr.head >= arr.length) return 1
      memo.getOrElseUpdate(startIdx, 1 + (1 to arr.head).map(jmp => run(arr.drop(jmp), startIdx + jmp)).min)
    }
    run(input, 0)
  }

  println(jumps(Seq(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))

}
