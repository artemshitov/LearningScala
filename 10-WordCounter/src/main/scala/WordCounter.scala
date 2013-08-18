package ru.artemshitov.wordcounter

class WordCounter(s: String) {
  private[this] val words = s.toLowerCase.split("\\W+")

  private[this] val counts =
    (Map[String, Int]() /: words) { (a, e) =>
      a + (e -> (a.getOrElse(e, 0) + 1))
    }.toList.sortWith(_._2 > _._2)

  private[this] lazy val uniqueWords = words.toSet

  def top(size: Int = uniqueWords.size) = counts.take(size)
}

object WordCounter {
  def main(args: Array[String]) {
    val counter = new WordCounter(args.mkString(" "))
    val counts  = counter.top()
    val output  = counts.map { x => x._1 + ": " + x._2 }

    println(output.mkString("\n"))
  }
}
