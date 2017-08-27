package fuzzy

trait Invertable[A] {
  type ¬[A]

  def invert(a: A): ¬[A]
}
