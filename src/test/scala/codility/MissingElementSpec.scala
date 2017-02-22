package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class MissingElementSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Seq(1), 2),
    (Seq(), 1),
    (Seq(2, 3, 1, 5), 4),
    ((1 to Int.MaxValue-1), Int.MaxValue),
    ((1 to Int.MaxValue).toSet.-(5).toSeq, 5),
    (Seq(2, 3, 1, 5, 6, 7, 8, 9, 10, 11, 12, 13), 4)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input: Seq[Int], result: Int) => {
      MissinElementSolution.solve(input) shouldBe result
    }
    }
  }
}