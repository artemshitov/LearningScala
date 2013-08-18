package ru.artemshitov.palindrome

class Palindrome(val s: String) {
  def isPalindrome: Boolean = s == s.reverse
}

object Palindrome {
  def apply(s: String): Palindrome = new Palindrome(s)
}
