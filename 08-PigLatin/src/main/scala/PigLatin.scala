package ru.artemshitov.pig_latin

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
