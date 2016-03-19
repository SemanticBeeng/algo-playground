package algoplayground

object LongestCommonSubseq extends App {

  def lcs(left: String, right: String): Int = {

    def run(l: String, r: String): Int = {
      if (l.isEmpty || r.isEmpty) return 0
      if (l.head == r.head) 1 + run(l.tail, r.tail)
      else Math.max(run(l.tail, r), run(l, r.tail))
    }
    run(left, right)
  }

  println(lcs("AGGTAB", "GXTXAYB")) // == "GTAB"

}
