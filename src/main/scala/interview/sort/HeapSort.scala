package interview.sort

object HeapSort {
  def sort[T <% Ordered[T]](array: Array[T]) {
    val heap = new Heap(array)

    for (i <- array.length to 2 by -1) {
      val v = array(i-1)
      array(i-1) = array(0)
      array(0) = v
      heap.heapSize -= 1
      heap.heapify(1)
    }
  }
}

object Heap {
  def heapify[T <% Ordered[T]](arr: Array[T])  {
    new Heap(arr)
  }
}

protected[sort] class Heap[T <% Ordered[T]](val underlying: Array[T]) {
  var heapSize = underlying.length

  ((underlying.length / 2) to 1 by -1) foreach heapify

  def heapify(i: Int) {
    val left = leftIndex(i)
    val right = rightIndex(i)

    val max = ((Some(i) :: left :: right :: Nil).flatten map (idx => (idx, underlying(idx - 1)))).maxBy(_._2)

    if (max._1 != i) {
      val v = underlying(max._1 - 1)
      underlying(max._1 - 1) = underlying(i - 1)
      underlying(i - 1) = v
      heapify(max._1)
    }
  }

  def leftIndex(i: Int) = bounded(2 * i)

  def rightIndex(i: Int) = bounded(2 * i + 1)

  def parentIndex(i: Int) = bounded(i / 2)

  private def bounded(i: Int) = i match {
    case v if v > heapSize => None
    case v if v < 1 => None
    case v => Some(v)
  }
}