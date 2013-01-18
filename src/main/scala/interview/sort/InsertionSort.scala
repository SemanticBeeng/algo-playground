package interview.sort

object InsertionSort {
  def sort[T <% Ordered[T]](array: Array[T]) {
    if (array.length == 0 || array.length == 1) return
    
    for (j <- 1 to array.length-1) {
      for (i <- j-1 to 0 by -1) {
        if (array(i) > array(i+1)) {
          val v = array(i)
          array(i) = array(i+1)
          array(i+1) = v
        }
      }
    }    
  }
}