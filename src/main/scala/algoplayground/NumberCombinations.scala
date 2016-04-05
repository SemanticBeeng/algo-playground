package algoplayground


object NumberCombinations extends App {

  def combinations(k: Int, numbers: Seq[Int]): Seq[Seq[Int]] = {
    if (k < 1) sys.error("wtf")
    if (k == 1) return numbers.map(n => Seq(n))
    numbers.flatMap(n => combinations(k - 1, numbers.filter(_ != n)).map(n +: _))
  }

  def uniqueCombinations(k: Int, numbers: Seq[Int]): Seq[Seq[Int]] = {
    if (k > numbers.length) return Seq.empty
    if (k < 1) sys.error("wtf")
    if (k == 1) return numbers.map(n => Seq(n))

    numbers.indices.flatMap { idx =>
      uniqueCombinations(k - 1, numbers.drop(idx + 1)).map(numbers(idx) +: _)
    }
  }

  println(combinations(2, Seq(1, 2, 3, 4)))
  println(combinations(3, Seq(1, 2, 3)))


  println(uniqueCombinations(2, Seq(1, 2, 3, 4)))
  println(uniqueCombinations(3, Seq(1, 2, 3, 4)))

}
