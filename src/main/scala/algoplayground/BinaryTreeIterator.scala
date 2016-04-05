package algoplayground

import java.util


object BinaryTreeIterator extends App {

  case class TreeNode[T](value: T, l: Option[TreeNode[T]], r: Option[TreeNode[T]])

  def iterator[T](root: TreeNode[T]): Iterator[T] = {
    new Iterator[T] {
      val stack = new util.Stack[TreeNode[T]]

      def goLeft(node: TreeNode[T]): Unit = {
        stack.push(node)
        node.l.foreach(goLeft)
      }
      goLeft(root)

      def hasNext: Boolean = !stack.isEmpty

      def next(): T = {
        val pop = stack.pop()
        pop.r.foreach(goLeft)
        pop.value
      }
    }

  }

  //        1
  //     /    \
  //    2      3
  //  /  \    /  \
  //  4   5  6    7
  val tree = TreeNode(1,
    l = Some(TreeNode(2,
      l = Some(TreeNode(4, None, None)),
      r = Some(TreeNode(5, None, None)))),
    r = Some(TreeNode(3,
      l = Some(TreeNode(6, None, None)),
      r = Some(TreeNode(7, None, None))))
  )

  val i = iterator(tree)
  println(i.toList)

}
