package ru.artemshitov.wordcounter

object Preamble {
  implicit def stringToWordCounter(s: String) = new WordCounter(s)
}
