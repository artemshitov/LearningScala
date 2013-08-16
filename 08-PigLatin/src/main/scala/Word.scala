package ru.artemshitov.pig_latin

class Word(original: String) {
  private val vowels = "aeouiy"
  private val word = original.toLowerCase()

  def toPigLatin: String = {
    val (prefix, body) = word.toList.span(!vowels.contains(_))
    val res = (prefix, body) match {
      case (Nil, 'y' :: x :: xs) if vowels.contains(x) => (x :: xs).mkString + "yay"
      case (Nil, _) => body.mkString + "way"
      case _ => (body ::: prefix).mkString + "ay"
    }

    if (original(0).isUpper) res.capitalize else res
  }
}
