package algoplayground.tree

case class TreeNode[T](
  value: T,
  l: Option[TreeNode[T]],
  r: Option[TreeNode[T]]
)
