package interview.sort

import org.scalatest.FlatSpec
import util.Random

class SortingSpec extends FlatSpec {
  "Insertion sort" should "sort array" in {
    val array = (1 to 10).map(_ => Random.nextInt(100)).toArray
    InsertionSort.sort(array)

    assert(array.toList == array.sorted.toList, "Sorted array = " + array.toList + ", expected = " + array.sorted.toList)
  }

  "Bubble sort" should "sort array" in {
    val array = (1 to 10).map(_ => Random.nextInt(100)).toArray
    BubbleSort.sort(array)

    assert(array.toList == array.sorted.toList, "Sorted array = " + array.toList + ", expected = " + array.sorted.toList)
  }

  "Merge sort" should "sort array" in {
    val array = (1 to 10).map(_ => Random.nextInt(100)).toArray
    MergeSort.sort(array)

    assert(array.toList == array.sorted.toList, "Sorted array = " + array.toList + ", expected = " + array.sorted.toList)
  }

  "ImmutableMerge sort" should "sort array" in {
    val list = (1 to 10).map(_ => Random.nextInt(100)).toList
    val sortedList = ImmutableMergeSort.sort(list)

    assert(sortedList == list.sorted, "Sorted list = " + list + ", expected = " + list.sorted)
  }

}