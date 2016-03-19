package algoplayground


object ConsecutiveIntegers extends App {

  def numberOfConsecutiveIntegers(arr: Array[Int]): Int = {

    var max: Int = 1
    var current: Int = 1

    var prevValue: Int = arr(0)

    var i: Int = 1
    while (i <= arr.length - 1) {
      if (prevValue + 1 == arr(i)) {
        current += 1
      } else {
        max = Math.max(max, current)
        current = 1
      }
      prevValue = arr(i)
      i += 1
    }
    max
  }

  def consecutiveIntegers(arr: Array[Int]): Array[Int] = {
    var maxStart: Int = 0
    var maxLength: Int = 1

    var start: Int = 0
    var length: Int = 1

    for (i <- 1 until arr.length) {
      if (arr(i - 1) + 1 == arr(i)) {
        length += 1
      } else {
        if (length > maxLength) {
          maxLength = length
          maxStart = start
        }
        length = 1
        start = i
      }
    }

    arr.slice(maxStart, maxStart + maxLength)
  }

  assert(1 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 0, 4, 2, 6)))
  assert(2 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 2, 4, 2, 6)))
  assert(3 == ConsecutiveIntegers.numberOfConsecutiveIntegers(Array(1, 2, 3, 2, 6)))

  assert(Seq(1) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 0, 4, 2, 6)).toSeq)
  assert(Seq(1, 2) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 2, 4, 2, 6)).toSeq)
  assert(Seq(1, 2, 3) == ConsecutiveIntegers.consecutiveIntegers(Array(1, 2, 3, 2, 6)).toSeq)

}
