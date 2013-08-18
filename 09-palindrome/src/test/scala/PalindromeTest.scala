import org.scalatest.FunSuite
import ru.artemshitov.palindrome.Palindrome

class PalindromeSuite extends FunSuite {
  test ("detects palindromes") {
    assert(Palindrome("racecar").isPalindrome)
  }

  test ("detects non-palindromes") {
    assert(!Palindrome("not a palindrome").isPalindrome)
  }
}
