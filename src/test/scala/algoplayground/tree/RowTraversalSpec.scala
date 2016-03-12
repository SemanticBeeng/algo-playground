package algoplayground.tree

import org.scalatest.FlatSpec


class RowTraversalSpec extends FlatSpec {

  //    1
  //   / \
  //  2   3
  val tree1 = TreeNode(1, Some(TreeNode(2, None, None)), Some(TreeNode(3, None, None)))

  "RowTraversal" should "compute row sum" in {
    val sum: (Int, Int) => Int = _ + _
    val out = RowTraversal.foldRows(tree1, sum, 0)
    assert(out == Seq((0, 1), (1, 5)))
  }

  it should "compute row avg" in {
    val sumAndCnt: ((Int, Int), Int) => (Int, Int) = {
      case ((s, n), next) => (s + next, n + 1)
    }
    val out = RowTraversal.foldRows(tree1, sumAndCnt, (0, 0)).map { case (rowNum, (sum, num)) => (rowNum, sum.toDouble / num)}
    assert(out == Seq((0, 1.0), (1, 2.5)))
  }

}
