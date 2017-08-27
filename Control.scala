package fuzzy

trait Control[A] {
  def control(a: A): Boolean
}
