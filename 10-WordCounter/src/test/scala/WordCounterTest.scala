import org.scalatest.FunSuite
import ru.artemshitov.wordcounter.WordCounter
import ru.artemshitov.wordcounter.Preamble._

class WordCounterSuite extends FunSuite {
  val s =
    """
    |One two three-four five six seven eight nine ten
    |One two three four five six seven eight nine
    |One two,three four five six seven eight
    |One two three four five six seven
    |One two (three) four five six
    |One two three four five
    |One two three four
    |One two three
    |One two
    |One
    """.stripMargin

  val top5 = List(
    ("one", 10),
    ("two", 9),
    ("three", 8),
    ("four", 7),
    ("five", 6)
  )

  test ("finds top 5 words in a string") {
    expectResult(top5) { s.top(5) }
  }
}
