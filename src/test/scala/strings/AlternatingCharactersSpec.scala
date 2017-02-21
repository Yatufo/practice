package strings

import org.scalatest._

class AlternatingCharactersSpec extends FlatSpec with Matchers {




  val test1 = "AAAA"
  val test2 = "BBBBB"
  val test3 = "ABABABAB"
  val test4 = "BABABA"
  val test5 = "AAABBB"

  val test1Count = 3
  val test2Count = 4
  val test3Count = 0
  val test4Count = 0
  val test5Count = 4

  "Solution" should "count the amount of characters to be deleted" in {
    AlternatingSolution.countDeletions(test1) shouldBe test1Count
    AlternatingSolution.countDeletions(test2) shouldBe test2Count
    AlternatingSolution.countDeletions(test3) shouldBe test3Count
    AlternatingSolution.countDeletions(test4) shouldBe test4Count
    AlternatingSolution.countDeletions(test5) shouldBe test5Count
  }


}