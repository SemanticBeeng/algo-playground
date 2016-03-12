package algoplayground.minpartition


object MinPartition {

  def isPalindrom(str: String): Boolean = str.reverse == str

  def minPartition(str: String): Int = {
    if (isPalindrom(str)) return 0

    (1 until str.length)
      .map(n => 1 + minPartition(str.take(n)) + minPartition(str.drop(n)))
      .min
  }

}
