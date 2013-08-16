package ru.artemshitov.pig_latin

// The usual rules for changing standard English into Pig Latin are as follows:
// For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the word, and "ay" is added, as in the following examples:
// "happy" → "appyhay"
// "duck" → "uckday"
// "glove" → "oveglay"

// For words that begin with vowel sounds or silent letter, "way" is added at the end of the word. Examples are
// "egg" → "eggway"
// "inbox" → "inboxway"
// "eight" → "eightway"

// The letter 'y' can play the role of either consonant or vowel, depending on its location
// "yellow" → "ellowyay"
// "rhythm" → "ythmrhay"

class Word(original: String) {
  def toPigLatin: String = {
    if (original.startsWith("y"))
      new Word(original.drop(1) + "y").toPigLatin
    else {
      val (prefix, body) = original.toList.span(!"aeouiy".contains(_))
      prefix match {
        case Nil => body.mkString + "way"
        case _   => body.mkString + prefix.mkString + "ay"
      }
    }
  }
}

object PigLatin {
  def translate(input: String): String = {
    val words =
      for (w <- input.split(" "))
        yield new Word(w).toPigLatin

    words.mkString(" ")
  }

  def main(args: Array[String]) {
    println(PigLatin.translate(args(0)))
  }
}
