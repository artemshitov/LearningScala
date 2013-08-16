import org.scalatest.FunSuite
import ru.artemshitov.pig_latin.Word

class WordSuite extends FunSuite {
  private def testWords(words: Map[String, String]) {
    for ((key, value) <- words)
      expectResult(value){new Word(key).toPigLatin}
  }

  test("words beginning with consonants") {
    testWords(
      Map(
        "happy" -> "appyhay",
        "duck" -> "uckday",
        "glove" -> "oveglay"
      )
    )
  }

  test("words beginning with vowels") {
    testWords(
      Map(
        "egg" -> "eggway",
        "inbox" -> "inboxway",
        "eight" -> "eightway"
      )
    )
  }

  test("words with y") {
    testWords(
      Map(
        "yellow" -> "ellowyay",
        "rhythm" -> "ythmrhay",
        "ytterbium" -> "ytterbiumway"
      )
    )
  }
}
