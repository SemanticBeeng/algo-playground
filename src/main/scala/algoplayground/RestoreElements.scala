package algoplayground


object RestoreElements extends App {

  /**
    * Given a set of numbers {x1, x2, x3, x4, ..., xN} (N>=3) a set of its pairwise sums is
    * {x1+x2, x1+x3, x1+x4, x2+x3,x2+x4,x3+x4, ...,}. (That is s_k = x_i + x_j where i != j)
    * Restore a set of numbers given a set of its pairwise sums.
    * Note: you don't know given some k, to which i and j it refers, (i.e. input is given in undefined order)
    *
    *
    * EDIT: couldn't comment, so here is clarification
    *
    * Example:
    *
    *
    * S = {1, 5, 10, 100} (n elements)
    * P = {6, 11, 101, 15, 105, 110} (n * (n - 1) / 2 elements)
    * Given P you have to restore S.
    * Note here means that if you knew which element in P corresponded to which pair of indices in S, you could just solve a simple linear equation
    *
    *
    * x1+x2=a{k1} x2+x3 = a{k2}, ...., x{n-1} + x{n} = a{k{n-1}, x{n} + x1 = a{k{n}}
    */


  def encode(arr: Seq[Int]): Seq[Int] = {
    for {
      i <- 0 until arr.length - 1
      j <- i + 1 until arr.length
    } yield arr(i) + arr(j)
  }

  val idx = Stream.iterate((0, 0)) { case (idx, step) => (idx + step + 1, step + 1) }.map(_._1)

  def restore(arr: Seq[Int]): Seq[Int] = {
    val rev = arr.reverse.toArray
    val last = (rev(0) + rev(1) - rev(2)) / 2
    (last +: idx.takeWhile(_ < rev.length).map(rev.apply).map(_ - last).toSeq).reverse
  }

  println(encode(Seq(1, 5, 10, 12, 15, 16, 100)))
  println(restore(encode(Seq(1, 5, 10, 12, 15, 16, 100))))
  println(restore(Seq(6, 11, 101, 15, 105, 110)))

}
