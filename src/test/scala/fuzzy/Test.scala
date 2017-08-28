package fuzzy
package test

import shapeless._

object Test {
  sealed trait Ball
  case object Black extends Ball
  case object White extends Ball

  type W = White.type
  type B = Black.type

  implicit val whiteNot = new Invertable[W] {
    type ¬[W] = B
    def invert(white: W): ¬[W] = Black
  }

  implicit val blackNot = new Invertable[B] {
    type ¬[B] = W
    def invert(black: B): ¬[B] = White
  }

  val white: White.type = Logic.not(Black)
  val black: Black.type = Logic.not(White)

  // won't compile
  //val black: Black.type = Logic.inverter(Black)
}
