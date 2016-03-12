package algoplayground.tree

case class TreeNode[T](
  value: T,
  left: Option[TreeNode[T]],
  right: Option[TreeNode[T]]
)
