package scalastuff.uniontypes

sealed abstract class StringOrInt[T] {
  def introduce: String
}

object StringOrInt {

  implicit object IntWitness extends StringOrInt[Int] {
    def introduce = "IntWitness"
  }

  implicit object StringWitness extends StringOrInt[String] {
    def introduce = "StringWitness"
  }

}

object Bar {
  def foo[T: StringOrInt](x: T) {
    println(implicitly[StringOrInt[T]].introduce)
    x match {
      case _: String => println("str")
      case _: Int => println("int")
    }
  }
}

object UnionTypesApp extends App {
  System.out.println("UnionTypes")

  import Bar._
  foo(1)
  foo("1")
}



