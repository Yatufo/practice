package search

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class MissingNumberSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "missing", "result"),
    (Array(1, 2, 3), Array(1, 2), Array(3)),
    (Array(203, 204, 205, 206, 207, 208, 203, 204, 205, 206), Array(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204), Array(204, 205, 206)))

  it should "get the gem stone for the sample" in {
    forAll(testCases) { (input: Array[Int], missing: Array[Int], result: Array[Int]) => {
      MissingNumberSolution.solve(input, missing) shouldBe result
    }
    }
  }

}