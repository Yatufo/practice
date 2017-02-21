package strings

import org.scalatest._

class FunnyWordSpec extends FlatSpec with Matchers {

  val word1 = "acxz"
  val word2 = "bcxz"
  it should "get the gem stone for the sample" in {
    FunnyWordSolution.solve(word1) shouldBe true
    FunnyWordSolution.solve(word2) shouldBe false
  }

}