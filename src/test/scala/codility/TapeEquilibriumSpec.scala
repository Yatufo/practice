package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class TapeEquilibriumSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Seq(3, 2), 1),
    (Seq(-3, -2), 1),
    (Seq(-1000, 1000), 2000),
      (Seq(3, 1 , 2, 4, 3), 1)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input: Seq[Int], result: Int) => {
      TapeEquilibriumSolution.solve(input) shouldBe result
    }
    }
  }
}