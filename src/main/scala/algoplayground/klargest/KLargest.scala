package algoplayground.klargest

object KLargest {

  class Heap(init: Seq[Int]) {
    private val arr = init.toArray

    private def leftChild(pos: Int) = pos * 2

    private def rightChild(pos: Int) = pos * 2 + 1

    private def isLeaf(pos: Int) = pos >= arr.length / 2

    private def swap(l: Int, r: Int): Unit = {
      val v = arr(l)
      arr(l) = arr(r)
      arr(r) = v
    }

    private def heapify(pos: Int): Unit = {
      if (!isLeaf(pos)) {
        if (arr(pos) > arr(leftChild(pos)) || arr(pos) > arr(rightChild(pos))) {
          if (arr(leftChild(pos)) < arr(rightChild(pos))) {
            swap(pos, leftChild(pos))
            heapify(leftChild(pos))
          } else {
            swap(pos, rightChild(pos))
            heapify(rightChild(pos))
          }
        }
      }
    }

    // Heapify after initialization
    for (i <- 0 to arr.size / 2) heapify(i)

    def insert(el: Int): Unit = {
      if (el > arr(0)) {
        arr(0) = el
        heapify(0)
      }
    }

    def toList = arr.toList
  }

  def topK(k: Int, seq: Seq[Int]): Seq[Int] = {
    assume(k < seq.size)

    val heap = new Heap(seq.take(k))
    seq.drop(k).foreach(el => heap.insert(el))
    heap.toList
  }

}
