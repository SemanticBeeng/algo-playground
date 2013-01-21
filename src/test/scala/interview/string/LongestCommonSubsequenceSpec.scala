package interview.string

import org.scalatest.FlatSpec

class LongestCommonSubsequenceSpec extends FlatSpec {
  "LongesCommonSubsequence algo" should "find LCS" in {
    val s1 = "SUBSEQUENCE"
    val s2 = "SUBEUENCS"

    val lcs = LongestCommonSubsequence(s1, s2)

    System.out.println(lcs)

    assert(lcs.lcs == "UENC")
  }

}