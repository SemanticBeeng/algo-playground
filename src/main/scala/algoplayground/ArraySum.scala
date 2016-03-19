package algoplayground


object ArraySum extends App {

  /**
    * Given an array and a number, add it in such a way where array is [0,0,1] and number is 4 output will be [0,0,5]
    *
    * Example 2 :
    * array is [1] and number is 9 output will be [1,0]
    *
    */

  def sum(arr: Seq[Int], n: Int): Seq[Int] = {

    val (c, a) = arr.reverse.foldLeft((n, Seq.empty[Int])) {
      case ((carryOver, acc), num) if carryOver + num < 10 => (0, acc :+ (carryOver + num))
      case ((carryOver, acc), num) => (1, acc :+ (carryOver + num) % 10)
    }

    (if (c > 0) a :+ c else a).reverse
  }

  println(sum(Seq(0, 0, 1), 4))
  println(sum(Seq(1), 9))
  println(sum(Seq(8), 9))
  println(sum(Seq(9), 9))
  println(sum(Seq(0, 9, 9), 9))





}
