package strings

import org.scalatest._

class PalindromeLetterSpec extends FlatSpec with Matchers {




  val test1 = "abc"
  val test2 = "abcba"
  val test3 = "abcd"
  val test4 = "cba"

  val test1Count = 2
  val test2Count = 0
  val test3Count = 4
  val test4Count = 2

  "Solution" should "count the amount of operations" in {
    PalindromeLetterSolution.countOperations(test1) shouldBe test1Count
    PalindromeLetterSolution.countOperations(test2) shouldBe test2Count
    PalindromeLetterSolution.countOperations(test3) shouldBe test3Count
    PalindromeLetterSolution.countOperations(test4) shouldBe test4Count
  }

  "Solution" should "count the amount of characters to be deleted" in {
    PalindromeLetterSolution.countOperations("cca") shouldBe 2
    PalindromeLetterSolution.countOperations("cbca") shouldBe 3
    PalindromeLetterSolution.countOperations("za") shouldBe 25
  }


  "Solution" should "check if a word is palindrome" in {
    PalindromeLetterSolution.isPalindrome("abbbbba") shouldBe true
    PalindromeLetterSolution.isPalindrome("abcdcba") shouldBe true
    PalindromeLetterSolution.isPalindrome("abaa") shouldBe false
    PalindromeLetterSolution.isPalindrome("abba") shouldBe true
  }

}