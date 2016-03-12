package algoplayground.tree

import org.scalatest.FlatSpec


class ColumnTraversalSpec extends FlatSpec {

  //    1
  //   / \
  //  2   3
  val tree1 = TreeNode(1,
    l = Some(TreeNode(2,
      l = None,
      r = None)),
    r = Some(TreeNode(3,
      l = None,
      r = None))
  )

  //        1
  //     /    \
  //    2      3
  //  /  \    /  \
  //  4   5  6    7
  val tree2 = TreeNode(1,
    l = Some(TreeNode(2,
      l = Some(TreeNode(4, None, None)),
      r = Some(TreeNode(5, None, None)))),
    r = Some(TreeNode(3,
      l = Some(TreeNode(6, None, None)),
      r = Some(TreeNode(7, None, None))))
  )

  "Column Traversal" should "get all values by columns" in {
    val f: (Seq[Int], Int) => Seq[Int] = (acc, v) => acc :+ v
    val init = Seq.empty

    val out1 = ColumnTraversal.foldColumns(tree1, f, init)
    assert(out1(0) == Seq(1))
    assert(out1(-1) == Seq(2))
    assert(out1(1) == Seq(3))

    val out2 = ColumnTraversal.foldColumns(tree2, f, init)
    assert(out2(0) == Seq(1, 5, 6))
    assert(out2(-1) == Seq(2))
    assert(out2(1) == Seq(3))
    assert(out2(-2) == Seq(4))
    assert(out2(2) == Seq(7))
  }

}
