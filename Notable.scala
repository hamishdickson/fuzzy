package fuzzy

trait Notable[F[_]] {
	def not[T](f: F[T]): F[T]
}
