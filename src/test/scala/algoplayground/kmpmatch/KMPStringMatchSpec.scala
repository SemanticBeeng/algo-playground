package algoplayground.kmpmatch

import org.scalatest.FlatSpec

class KMPStringMatchSpec extends FlatSpec {

  "KMP Match" should "build correct longest common prefix-suffix array" in {
    val matches1 = KMPStringMatch.stringMatch("AABA".toCharArray, "AABAACAADAABAAABAA".toCharArray)
    assert(matches1.toList == Seq(0,9,13))

    val matches2 = KMPStringMatch.stringMatch("TEST".toCharArray, "THIS IS A TEST TEXT".toCharArray)
    assert(matches2.toList == Seq(10))
  }

}
