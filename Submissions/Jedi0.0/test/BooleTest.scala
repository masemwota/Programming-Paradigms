package test

import value._

object BooleTest extends App {
  val t = Boole(true)
  val f = Boole(false)
  println("t && f = " + (t && f))
  println("t || f = " + (t || f))
  println("!t = " + (!t))
}

/**
Output

t && f = Boole(false)
t || f = Boole(true)
!t = Boole(false)

*/