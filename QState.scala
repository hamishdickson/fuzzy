package fuzzy

import cats._
import cats.data._
import cats.implicits._

trait QState[T] {
	// this is the equivalent of unsafePerformIO
	def observe: T
}

object QState {

	// can I make a monoid?
	// this might be a semigroupK
}