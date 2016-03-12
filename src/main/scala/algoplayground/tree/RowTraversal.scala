package algoplayground.tree


object RowTraversal {

  def foldRows[T, R](root: TreeNode[T], f: (R, T) => R, init: R): Seq[(Int, R)] = {

    def children(node: TreeNode[T]): Seq[TreeNode[T]] = {
      val out = Seq.newBuilder[TreeNode[T]]
      node.l.foreach(out += _)
      node.r.foreach(out += _)
      out.result()
    }

    def run(nodes: Seq[TreeNode[T]], rowNum: Int): Seq[(Int, R)] = {

      if (nodes.isEmpty) return Seq.empty

      val rowValue = nodes.map(_.value).foldLeft(init)(f)
      val nextRow = nodes.flatMap(children)

      Seq(rowNum -> rowValue) ++ run(nextRow, rowNum + 1)
    }

    run(Seq(root), 0)
  }

}
