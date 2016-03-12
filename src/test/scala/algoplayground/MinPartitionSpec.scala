package algoplayground

import algoplayground.minpartition.MinPartition
import org.scalatest.FlatSpec


class MinPartitionSpec extends FlatSpec {

  "MinPartition" should "find palindrom splits" in {

    assert(0 == MinPartition.minPartition("aba"))
    assert(3 == MinPartition.minPartition("ababbbabbababa"))

  }

}
