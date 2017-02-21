package strings

import org.scalatest._

class PangramSpec extends FlatSpec with Matchers {

  val OkPangram1 = "We promptly judged antique ivory buckles for the next prize"
  val OkPangram2 = "The quick brown fox jumps over the lazy dog"

  "Solution" should "return true for a valid pangram" in {
    PangramSolution.isPangram(OkPangram1) shouldBe true
    PangramSolution.isPangram(OkPangram2) shouldBe true
  }

  val InvalidPangram = "We promptly judged antique ivory buckles for the prize"
  "Solution" should "return false for an invalid pangram" in {
    PangramSolution.isPangram(InvalidPangram) shouldBe false
  }

}