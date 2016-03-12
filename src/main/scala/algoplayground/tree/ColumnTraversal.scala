package algoplayground.tree

import scala.collection.mutable


object ColumnTraversal {

  def foldColumns[T, R](root: TreeNode[T], f: (R, T) => R, init: R): Map[Int, R] = {

    val state = mutable.Map.empty[Int, R]

    def run(node: TreeNode[T], column: Int): Unit = {
      val current = state.getOrElseUpdate(column, init)
      val next = f(current, node.value)
      state.update(column, next)

      node.l.foreach(run(_, column - 1))
      node.r.foreach(run(_, column + 1))
    }

    run(root, 0)

    state.toMap
  }

}
