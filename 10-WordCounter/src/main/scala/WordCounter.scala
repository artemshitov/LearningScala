package ru.artemshitov.wordcounter

class WordCounter(s: String) {
  private[this] val words = s.toLowerCase.split("[,. ?!:;()\n-]+").toList
  private[this] val counts =
    (Map[String, Int]() /: words) { (a, e) =>
      a + (e -> (a.getOrElse(e, 0) + 1))
    }.toList.sortWith(_._2 > _._2)

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
