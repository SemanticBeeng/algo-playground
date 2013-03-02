package scalastuff.implicits.hole

object Test extends App {

  implicit val rabbitHoleInOuterTest = new Hole[Rabbit] {
    def findHole(x: Rabbit) = "Rabbit found the hole in outer Test object"
  }

  {
    implicit val rabbitHoleInInnerTest = new Hole[Rabbit] {
      def findHole(x: Rabbit) = "Rabbit found the hole in inner Test object"
    }

    // println(findHole(Rabbit()))
  }
}