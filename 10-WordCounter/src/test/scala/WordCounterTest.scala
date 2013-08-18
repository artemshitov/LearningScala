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

  val top = List(
    ("one", 10),
    ("two", 9),
    ("three", 8),
    ("four", 7),
    ("five", 6),
    ("six", 5),
    ("seven", 4),
    ("eight", 3),
    ("nine", 2),
    ("ten", 1)
  )

  test("finds all words' counts") {
    expectResult(top) { s.top() }
  }

  test ("finds top 5 words in a string") {
    expectResult(top take 5) { s.top(5) }
  }
}
