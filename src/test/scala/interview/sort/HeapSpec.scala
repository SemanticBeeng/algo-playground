package interview.sort

import org.scalatest.FlatSpec
import scala.Predef._


class HeapSpec extends FlatSpec {

  "Heap" should "heapify" in {
    val heap = new Heap(Array(2, 4, 1, 8, 7, 9, 3, 14, 10, 16))
    assertHeapified(heap)
  }

  private def assertHeapified[T <% Ordered[T]](heap: Heap[T]) {
    System.out.println(heap.underlying.toList)
    for (i <- 1 to heap.heapSize) {
      val v = heap.underlying(i - 1)
      heap.parentIndex(i).map(idx => assert(v <= heap.underlying(idx - 1), s"Failed for idx = $idx, i = $i"))
      heap.leftIndex(i).map(idx => assert(v >= heap.underlying(idx - 1), s"Failed for idx = $idx, i = $i"))
      heap.rightIndex(i).map(idx => assert(v >= heap.underlying(idx - 1), s"Failed for idx = $idx, i = $i"))
    }
  }

}