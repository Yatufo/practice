package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class CyclicRotationSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "k", "result"),
    (Seq(3, 8, 9, 7, 6), 3, Seq(9, 7, 6, 3, 8)),
    (Seq(1, 2, 3), 3, Seq(1, 2, 3)),
    (Seq(1, 2, 3), 0, Seq(1, 2, 3)),
    (Seq(1, 2, 3, 4, 5, 6, 7, 8), 3, Seq(6, 7, 8, 1, 2, 3, 4, 5)),
    (Seq(1), 3, Seq(1))
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input: Seq[Int], k: Int, result: Seq[Int]) => {
      CyclicRotationSolution.solve(input, k) shouldBe result
    }
    }
  }
}