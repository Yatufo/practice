package strings

import org.scalatest._

class AnagramPalindromeSpec extends FlatSpec with Matchers {

  val OkWord1 = "aaaabbbbb"
  val OkWord2 = "abcab"
  val OkWord3 = "aaaabbbbcccc"

  "Solution" should "have a valid anagram also palindrome" in {
    AnagramPalindromeSolution.hasAnagramPalindrome(OkWord1) shouldBe true
    AnagramPalindromeSolution.hasAnagramPalindrome(OkWord2) shouldBe true
  }

  val InvalidWord = "aaacccbbb"
  "Solution" should "NOT have a valid anagram also palindrome" in {
    AnagramPalindromeSolution.hasAnagramPalindrome(InvalidWord) shouldBe false
  }

}