package algoplayground

object WaterFill {


  val arr = Array(2, 5, 1, 2, 3, 4, 7, 7, 6)

  def value(arr: Array[Int]): Int = {

    val n = arr.length
    val leftMax: Array[Int] = Array.ofDim(n)
    val rightMax: Array[Int] = Array.ofDim(n)

    leftMax(0) = 0

    var i: Int = 1
    while (i < n) {
      if (arr(i - 1) > leftMax(i - 1)) {
        leftMax(i) = arr(i - 1)
      } else {
        leftMax(i) = leftMax(i - 1)
      }
      i += 1
    }

    rightMax(n - 1) = 0
    i = n - 2
    while (i >= 0) {
      if (arr(i + 1) > rightMax(i + 1)) {
        rightMax(i) = arr(i + 1)
      } else {
        rightMax(i) = rightMax(i + 1)
      }
      i -= 1
    }

    i = 0
    var volume: Int = 0
    while (i < n) {
      val bound = Math.min(leftMax(i), rightMax(i))
      volume += Math.max(0, bound - arr(i))
      i += 1
    }
    volume
  }

  def main(args: Array[String]): Unit = {
    println(value(arr))
    println(value(Array(10, 9, 8, 7, 5, 4, 3, 2, 1)))
    println(value(Array(2,5,3,3,7,2,7,6)))
  }

}
