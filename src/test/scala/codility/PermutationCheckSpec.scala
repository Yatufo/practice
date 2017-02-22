package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class PermutationCheckSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Seq(1), 1),
    (Seq(2), 0),
    (Seq(2, 1), 1),
    (Seq(2, 3), 0),
    (util.Random.shuffle(2 to 100).toSeq, 0),
    (Seq(4,1,3), 0),
    (Seq(4,1,3,2), 1)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input: Seq[Int], result: Int) => {
      PermutationCheck.solve(input) shouldBe result
    }
    }
  }
}