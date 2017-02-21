package strings

import org.scalatest._

class AnagramWordSpec extends FlatSpec with Matchers {

  val words1 = "aaabbb,ab,abc,mnop,xyyx,xaxbbbxx".split(",")
  val solutions1 = Array(3, 1, -1, 2, 0, 1)

  it should "get the gem stone for the sample" in {
    for (i <- 0 until words1.length){
      AnagramSolution.solve(words1(i)) shouldBe solutions1(i)
    }

  }

}