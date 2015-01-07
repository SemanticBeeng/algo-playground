package algoplayground.kmpmatch

import org.scalatest.FlatSpec

class KMPStringMatchSpec extends FlatSpec {

  "KMP Match" should "build correct longest common prefix-suffix array" in {
    KMPStringMatch.stringMatch("AABA".toCharArray, "AABAACAADAABAAABAA".toCharArray)
    KMPStringMatch.stringMatch("TEST".toCharArray, "THIS IS A TEST TEXT".toCharArray)
  }

}
