package scalastuff.implicits.hole

case class Rabbit()

trait Hole[A] {
  def findHole(x: A): String
}

object Hole {
  def apply[A : Hole] = implicitly[Hole[A]]
  implicit val rabbitHoleInHole = new Hole[Rabbit] {
    def findHole(x: Rabbit) = "Rabbit found the hole in Hole companion object"
  }
}