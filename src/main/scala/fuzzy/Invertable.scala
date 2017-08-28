package fuzzy

trait Invertable[A] {
  type ¬[A]

  def invert(a: A): ¬[A]
}

object Invertable {
  // hmmmm dunno about this from here on in
  implicit def hnilInvertable[HNil] = new Invertable[HNil] {
    type ¬[HNil] = HNil
    def invert(hnil: HNil): ¬[HNil] = hnil
  }

/*
  implicit def hconsInvertable[H, T <: HList](
    implicit
    hInvertable: Invertable[H],
    tInvertable: Invertable[T]
  ): Invertable[H :: T] = new Invertable[H :: T] {
    type HT = H :: T
    type ¬[HT] = ???
    def invert(ls: H :: T): ¬[H :: T] = ???
  }
  */
}
