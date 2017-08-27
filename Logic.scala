package fuzzy

import shapeless._

object Logic {

  // this is dodgy and should never be used - there is an assumption about excluded middles here
  // todo - think about using a topos
  //type ¬¬[A] = ¬[¬[A]]  

	def not[A](a: A)(implicit nope: Invertable[A]): nope.¬[A] = nope.invert(a)

	// todo figure out how to express this type
	// todo could use a poly and a map here
	def cnot[A, B](ab: A :: B :: HNil)(implicit cont: Control[A], nope: Invertable[B]) =
		if (cont.control(ab.head)) ab.head :: nope.invert(ab.tail.head) :: HNil
		else ab.head :: ab.tail.head :: HNil
}
