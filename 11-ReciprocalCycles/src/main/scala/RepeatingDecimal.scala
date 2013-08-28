package ru.artemshitov.reciprocalcycles

class RepeatingDecimal(val num: Int, val denom: Int) {
  val int = num / denom
  val (base, period) = {
    def divide(i: Int, rems: List[Int], quots: List[Int]): (String, String) = i match {
      case 0 => (quots.reverse.mkString, "")
      case x if rems.contains(x) => {
        val (base, period) = rems.zip(quots).reverse.span(_._1 != x)
        (base.unzip._2.mkString, period.unzip._2.mkString)
      }
      case x if x < denom => divide(x * 10, x :: rems, 0 :: quots)
      case _ => divide((i % denom) * 10, i :: rems, (i / denom) :: quots)
    }

    divide(num % denom * 10, Nil, Nil)
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
