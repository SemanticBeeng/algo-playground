package algoplayground.sort


object ImmutableMergeSort {
  def sort[T <% Ordered[T]](list: List[T]): List[T] = {
    if (list.length == 1) return list

    val (left, right) = list.splitAt(list.length / 2)
    val sortedLeft = sort(left)
    val sortedRight = sort(right)
    merge(sortedLeft, sortedRight)
  }

  def merge[T <% Ordered[T]](left: List[T], right: List[T]): List[T] = {
    (left.headOption, right.headOption) match {
      case (Some(lv), Some(rv)) if (lv <= rv) => lv :: merge(left.tail, right)
      case (Some(lv), Some(rv)) if (rv <= lv) => rv :: merge(left, right.tail)
      case (None, Some(rv)) => rv :: merge(left, right.tail)
      case (Some(lv), None) => lv :: merge(left.tail, right)
      case (None, None) => Nil
    }
  }
}