package ru.artemshitov.wordcounter

class WordCounter(s: String) {
  private[this] val words = s.toLowerCase.split("[,. ?!:;()\n-]+").toList
  private[this] val counts =
    (Map[String, Int]() /: words) { (a, e) =>
      if (a.isDefinedAt(e))
        a + (e -> (a(e) + 1))
      else
        a + (e -> 1)
    }.toList.sortBy(_._2).reverse

  def top(size: Int) = counts.take(size)
  def uniqueWords = words.toSet
}

object WordCounter {
  def main(args: Array[String]) {
    val counter = new WordCounter(args.mkString(" "))
    val counts  = counter.top(counter.uniqueWords.size)
    val output  = counts.map { x => x._1 + ": " + x._2 }

    println(output.mkString("\n"))
  }
}
