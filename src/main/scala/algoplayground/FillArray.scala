package algoplayground


object FillArray {

  case class Move(next: (Int, Int) => (Int, Int), turn: Int)

  def fill(n: Int): Array[Array[Int]] = {

    val arr = Array.fill(n, n)(-1)

    val right: Move = Move((i, j) => (i, j + 1), 1)
    val down: Move  = Move((i, j) => (i + 1, j), 2)
    val left: Move  = Move((i, j) => (i, j - 1), 3)
    val up: Move    = Move((i, j) => (i - 1, j), 0)

    val direction: Map[Int, Move] = Map(
      0 -> right,
      1 -> down,
      2 -> left,
      3 -> up
    )

    val init: ((Int, Int), Move) = ((0, 0), right)

    (0 until (n * n)).foldLeft(init) { case (((i, j), move), idx) =>
      arr(i)(j) = idx
      val (ii, jj) = move.next(i, j)
      if (ii >= n || ii < 0 || jj >= n || jj < 0 || arr(ii)(jj) > -1) {
        val nextMove = direction(move.turn)
        val (ii, jj) = nextMove.next(i, j)
        ((ii, jj), nextMove)
      } else {
        ((ii, jj), move)
      }
    }

    arr
  }

  def main(args: Array[String]): Unit = {
    val arr = fill(10)
    arr.foreach(l => println(l.map(_.toString).mkString(", ")))
  }
}
