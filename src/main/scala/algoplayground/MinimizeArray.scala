package algoplayground

object MinimizeArray extends App {

  /**
    * Find minimum possible size of array with given rules for removing elements
    * Given an array of numbers and a constant k, minimize size of array with following rules for removing elements.
    *
    * Exactly three elements can be removed at one go.
    * The removed three elements must be adjacent in array, i.e., arr[i], arr[i+1], arr[i+2]. And the second element must be k
    * greater than first and third element must be k greater than second, i.e., arr[i+1] – arr[i] = k and arr[i+2]-arr[i+1] = k.
    * Example:
    *
    * Input: arr[] = {2, 3, 4, 5, 6, 4}, k = 1
    * Output: 0
    * We can actually remove all elements
    * First remove 4, 5, 6 => We get {2, 3, 4}
    * Now remove 2, 3, 4   => We get empty array {}
    *
    * Input:  arr[] = {2, 3, 4, 7, 6, 4}, k = 1
    * Output: 3
    * We can only remove 2 3 4
    */

  def minimize(input: Seq[Int], k: Int): Int = {

    def run(seq: Seq[Int]): Int = {
      if (seq.length < 3) return seq.length

      val withSplit = {
        val splits = for {
          i <- 1     until seq.length - 1
          j <- i + 1 until seq.length
          if seq.head + k == seq(i)        &&
             seq(i) + k == seq(j)          &&
             run(seq.slice(1, i))     == 0 &&
             run(seq.slice(i + 1, j)) == 0
        } yield j

        if (splits.isEmpty) {
          seq.length
        } else {
          splits.map(j => run(seq.drop(j + 1))).min
        }
      }

      val withoutSplit = 1 + run(seq.tail)
      Math.min(withoutSplit, withSplit)
    }

    run(input)
  }

  println(minimize(Seq(2, 3, 4, 5, 6, 4), 1))
  println(minimize(Seq(2, 3, 4, 7, 6, 4), 1))

}
