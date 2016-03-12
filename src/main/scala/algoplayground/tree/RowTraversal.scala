package algoplayground.tree


object RowTraversal {

  def foldRows[T, R](root: TreeNode[T], f: (R, T) => R, init: R): Seq[(Int, R)] = {

    def children(node: TreeNode[T]): Seq[TreeNode[T]] = {
      val out = Seq.newBuilder[TreeNode[T]]
      node.left.foreach(out += _)
      node.right.foreach(out += _)
      out.result()
    }

    def foldRow(nodes: Seq[TreeNode[T]], rowNum: Int): Seq[(Int, R)] = {

      if (nodes.isEmpty) return Seq.empty

      val rowValue = nodes.map(_.value).foldLeft(init)(f)
      val nextRow = nodes.flatMap(children)

      Seq(rowNum -> rowValue) ++ foldRow(nextRow, rowNum + 1)
    }

    foldRow(Seq(root), 0)
  }

}
