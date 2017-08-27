package fuzzy

trait Notable[A] {
	type ¬[A]

	def not(a: A): ¬[A]

	def unchanged = this
}
