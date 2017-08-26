package fuzzy

object Logic {
	// not sure how useful this bit is
  type ¬[A] = A => Nothing

  // this is dodgy and should never be used - there is an assumption about excluded middles here
  // todo - think about using a topos
  //type ¬¬[A] = ¬[¬[A]]  

  def not[T](qs: => QState[T])(implicit notable: Notable[QState]): QState[T] = notable.not(qs)
}
