package fuzzy

object Logic {

  // this is dodgy and should never be used - there is an assumption about excluded middles here
  // todo - think about using a topos
  //type ¬¬[A] = ¬[¬[A]]  

	def inverter[A](a: A)(implicit nope: Notable[A]): nope.¬[A] = nope.not(a)
}
