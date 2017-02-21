package search

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class SherlockArrraySpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Array(1, 2, 3), "NO"),
    (Array(1, 2, 3, 3), "YES"))

  it should "get the gem stone for the sample" in {
    forAll(testCases) { (input: Array[Int], result: String) => {
      SherlockArraySolution.solve(input) shouldBe result
    }
    }
  }

}