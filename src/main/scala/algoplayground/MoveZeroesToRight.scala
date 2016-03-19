package algoplayground


object MoveZeroesToRight extends App {

  /**
    * Given an array of integers. Modify the array by moving all the zeros to the end (right side). The order of the other elements doesn't matter.
    */

  def moveZeroes(arr: Array[Int]): Array[Int] = {
    var l: Int = 0
    var r: Int = arr.length - 1
    while (l < r) {
      while (arr(l) != 0 && l < arr.length) l += 1
      while (arr(r) == 0 && r > 0) r -= 1
      if (l < r) {
        val v = arr(r)
        arr(r) = arr(l)
        arr(l) = v
      }
    }
    arr
  }

  println(moveZeroes(Array(1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9,0)).toSeq)


}
