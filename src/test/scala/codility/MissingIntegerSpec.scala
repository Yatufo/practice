package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class MissingIntegerSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Seq(1, 3), 2),
    (Seq(1), 2),
    (Seq(1, 3, 4), 2),
    (Seq(1, 3, 6, 4, 1, 2), 5),
    (Seq(-1,-2, 1, 2), 3),
    (Seq(-1, 1), 2),
    (Seq(-1, -2), 1),
    (Seq(2), 1),
    (Seq(150), 1),
    (Seq(9, 7, 5, 3, 1), 2),
    (Seq(1,2), 3)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input: Seq[Int], result: Int) => {
      MissinIntegerSolution.solve(input) shouldBe result
    }
    }
  }
}