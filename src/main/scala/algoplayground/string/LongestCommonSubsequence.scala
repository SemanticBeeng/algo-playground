package algoplayground.string

case class LCS(s1: String, s2: String, lcs: String)

object LongestCommonSubsequence {
  def apply(s1: String, s2: String): LCS = {
    val arr = Array.ofDim[Int](s1.length + 1, s2.length + 1)

    for (i <- 0 to s1.length) arr(i)(0) = 0
    for (j <- 0 to s2.length) arr(0)(j) = 0

    for (i <- 1 to s1.length) {
      for (j <- 1 to s2.length) {
        if (s1.charAt(i-1) equals s2.charAt(j-1)) {
          arr(i)(j) = 1 + arr(i-1)(j-1)
        } else {
          arr(i)(j) = 0
        }
      }
    }

    var length = 0
    var idx = 0
    for (i <- 1 to s1.length) {
      for (j <- 1 to s2.length) {
        if (arr(i)(j) > length) {
          length = arr(i)(j)
          idx = i
        }
      }
    }

    LCS(s1, s2, s1.substring(idx - length, idx))
  }

  def printArray(arr: Array[Array[Int]]) {
    for (i <- 0 to arr.length-1) {
      for (j <- 0 to arr(0).length - 1) {
        System.out.print(s"${arr(i)(j)}, ")
      }
      System.out.println("")
    }
  }
}