import algoplayground.SumsToValue
import org.scalatest.FlatSpec



class SumsToValueSpec extends FlatSpec {

  "SumToValue" should "work" in {

    val arr = Array[(Int, Int)]((1, 2), (5, 6), (3, 4), (3, 3), (1, 5), (5, 1), (5, 4))

    val out = SumsToValue.sumsToValue[(Int, Int)](arr, (6, 6), (l, r) => (l._1 + r._1, l._2 + r._2))

    assert(out == Seq( ((1, 2), (5, 4)), ((1, 5), (5, 1)) ))

  }

}
