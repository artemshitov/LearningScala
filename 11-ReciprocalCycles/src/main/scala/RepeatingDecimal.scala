package ru.artemshitov.reciprocalcycles

import scala.collection.mutable.ListBuffer

class RepeatingDecimal(val num: Int, val denom: Int) {
  val int = num / denom
  val (base, period) = {
    def divide(i: Int, remainders: ListBuffer[Int]): (String, String) = i match {
      case 0 => (quotientsFrom(remainders), "")
      case x if remainders.contains(x) => {
        val (baseRems, periodRems) = remainders.span(_ != x)
        (quotientsFrom(baseRems), quotientsFrom(periodRems))
      }
      case _ => divide((i % denom) * 10, remainders += i)
    }

    def quotientsFrom(rems: ListBuffer[Int]) = {
      rems.map(_ / denom).mkString
    }

    divide(num % denom * 10, ListBuffer[Int]())
  }

  override def toString: String = (int, base, period) match {
    case (_, "", "") => s"$int.0"
    case (_, _, "")  => s"$int.$base"
    case (_, "", _)  => s"$int.($period)"
    case _           => s"$int.$base($period)"
  }
}

object RepeatingDecimal {
  def apply(num: Int, denom: Int) = new RepeatingDecimal(num, denom)
}
