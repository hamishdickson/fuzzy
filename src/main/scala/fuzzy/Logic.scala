package fuzzy

import shapeless._

object Logic {
  def identity[A](a: A): A = a

  def not[A](a: A)(implicit nope: Invertable[A]): nope.¬[A] = nope.invert(a)

  /*
   todo have enough information to express this as a type:
   A :: (B | ¬[B]) :: HNil
  */
  def cnot[A, A0 <: Boolean, B](ab: A :: B :: HNil)(
    implicit
    cont: Control[A],
    nope: Invertable[B]
  ): HList =
    if (cont.control(ab.head)) ab.head :: nope.invert(ab.tail.head) :: HNil
    else ab.head :: ab.tail.head :: HNil

}
