package algoplayground


object ArraySumAndMult extends App {

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


  def sum2(l: Seq[Int], r: Seq[Int]): Seq[Int] = {
    val maxLen = Math.max(l.length, r.length)
    val (carry, acc) = (l.reverse.padTo(maxLen, 0) zip r.reverse.padTo(maxLen, 0)).foldLeft((0, Seq.empty[Int])) {
      case ((carryOver, acc), (ln, rn)) if carryOver + ln + rn < 10 => (0, acc :+ (carryOver + ln + rn))
      case ((carryOver, acc), (ln, rn)) => (1, acc :+ ((carryOver + ln + rn) % 10))
    }
    (if (carry == 0) acc else acc :+ carry).reverse
  }


  println(12345 + 456789)
  println(sum2(Seq(1, 2, 3, 4, 5), Seq(4, 5, 6, 7, 8, 9)).mkString(""))

  def multiply(l: Seq[Int], r: Seq[Int]): Seq[Int] = {

    val out = Array.fill(l.length + r.length)(0)

    var s = out.length - 1

    for (j <- (r.length - 1).to(0, -1)) {
      var carry: Int = 0
      var shift: Int = s

      for (i <- (l.length - 1).to(0, -1)) {
        val m = l(i) * r(j)
        val sum = m + out(shift) + carry
        val num = sum % 10
        val c = sum / 10
        out(shift) = num
        carry = c
        shift -= 1
      }
      out(shift) = out(shift) + carry
      s -= 1
    }

    out.toSeq
  }

  println(12345 * 678)
  println(multiply(Seq(1, 2, 3, 4, 5), Seq(6, 7, 8)).mkString(""))

}
