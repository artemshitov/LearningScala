package ru.artemshitov.reciprocalcycles

object ReciprocalCycles extends App {
  val decimals = for (i <- 1 until 1000) yield RepeatingDecimal(1, i)
  val answer = decimals.maxBy(_.period.length)

  println(answer.denom)
  println(answer)
}
