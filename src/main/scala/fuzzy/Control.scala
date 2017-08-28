package fuzzy

trait Control[A] {
  type OUT <: Boolean
  def control(a: A): OUT
}

object Control {
  type Aux[A0, B0] = Control[A0] { type OUT = B0 }
}
