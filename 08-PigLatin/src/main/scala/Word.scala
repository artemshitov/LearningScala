package ru.artemshitov.pig_latin

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
