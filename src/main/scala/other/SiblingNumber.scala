package other

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class SiblingNumberSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (123, 321),
    (456, 654)
  )
  it should "find the sibling number" in {
    forAll(testCases) { (input: Int, result: Int) => {
      SiblingNumber.solve(input) shouldBe result
    }
    }
  }

}

object SiblingNumber {


  def solve(i: Int): Int = {
    val digits: Seq[Int] = i.toString.split("").map(_.toInt)
    digits.sortWith(_ > _).map(_.toString).mkString("").toInt
  }



}