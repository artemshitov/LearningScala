package ru.artemshitov.pig_latin

class Word(original: String) {
  val vowels = "aeouiy"

  def toPigLatin: String = {
    val (prefix, body) = original.toList.span(!vowels.contains(_))
    (prefix, body) match {
      case (Nil, 'y' :: x :: xs) if vowels.contains(x) => (x :: xs).mkString + "yay"
      case (Nil, _) => body.mkString + "way"
      case _ => (body ::: prefix).mkString + "ay"
    }
  }
}
