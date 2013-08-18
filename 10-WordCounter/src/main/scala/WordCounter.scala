package ru.artemshitov.wordcounter

class Words(s: String) {
  val words = s.toLowerCase.split("[,. ?!:;()\n]+").toList
  val counts =
    (Map[String, Int]() /: words) { (a, e) =>
      if (a.isDefinedAt(e))
        a + (e -> (a(e) + 1))
      else
        a + (e -> 1)
    }.toList.sortBy(_._2).reverse


  def top(size: Int = 5): List[Tuple2[String, Int]] =
    counts.take(size)
}
