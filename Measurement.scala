package fuzzy

trait Measurement[T] {
  def decoherence: T = ???
}

object Measurement {
  import Logic._

  def not[A](a: => A)(implicit n: Not[A]): Measurement[¬[A]] = n.not(a)
  //def cNot[A](aa: => (A, A))(implicit n: Not[A]): Measurement[???] = ???
}

object Logic {
  type ¬[A] = A => Nothing

  // this is dodgy and should never be used - there is an assumption about excluded middles here
  type ¬¬[A] = ¬[¬[A]]
}

trait Not[T] {
  import Logic._

  def not: ¬[T]
}
