package fuzzy
package test

import shapeless._

object Test {
  sealed trait Ball
  case object Black extends Ball
  case object White extends Ball

  type W = White.type
  type B = Black.type

  implicit val whiteNot = new Invertable[W] {
    type ¬[W] = B
    def invert(white: W): ¬[W] = Black
  }

  implicit val blackNot = new Invertable[B] {
    type ¬[B] = W
    def invert(black: B): ¬[B] = White
  }

  val white: White.type = Logic.not(Black)
  val black: Black.type = Logic.not(White)

  // won't compile
  //val black: Black.type = Logic.inverter(Black)



	// hmmmm dunno about this from here on in

/*
	implicit def hnilNot[HNil] = new Notable[HNil] {
		type ¬[HNil] = HNil
		def not(hnil: HNil): ¬[HNil] = hnil
	}

	implicit def hconsNot[H, T <: HList](
		implicit
		hNot: Notable[H],
		tNot: Notable[T]
	): Notable[H :: T] = new Notable[H :: T] {
		type HT = H :: T
		type ¬[HT] = HT
		def not(ht: H :: T): ¬[HT] = hNot.not(ht.head) :: tNot.not(ht.tail)
	}

	implicit def cnilNot[CNil] = new Notable[CNil] {
		type ¬[CNil] = CNil
		def not(cnil: CNil): ¬[CNil] = throw new Exception("impossible")
	}

	implicit def headTailNot[H, T <: Coproduct](
		implicit
		hNot: Notable[H],
		tNot: Notable[T]
	): Notable[H :+: T] = new Notable[H :+: T] {
		type Foo = H :+: T
		type ¬[Foo] = ({ type T[A] = hNot#¬ :+: CNil })#T

		def not(ht: H :+: T): ¬[H :+: T] = ht match {
			case Inl(h) => hNot.not(h)
			case Inr(t) => tNot.not(t)
		}
	}
	*/
}
