package strings

import org.scalatest._

class GemeStoneSpec extends FlatSpec with Matchers {

  val rocks1 = Array("abcdde", "baccd", "eeabg")
  val rocks2 = Array("aaaaaaa", "bbbbbbbb", "ccccc")
  val rocks3 = Array("aaaaaaaccccb", "aaaaaabbbbbbcccc", "abc")

  it should "get the gem stone for the sample" in {
    GemeStoneSolution.solve(rocks1) shouldBe 2
    GemeStoneSolution.solve(rocks2) shouldBe 0
    GemeStoneSolution.solve(rocks3) shouldBe 3
  }

}