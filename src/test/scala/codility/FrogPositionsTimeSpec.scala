package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class FrogPositionsTimeSpec extends FlatSpec with Matchers {

  val testCases = Table(("postions", "width", "result"),
    (Seq(1, 3, 1, 4, 2, 3, 5, 4), 5, 6),
    (Seq(1, 2), 3, -1),
    (Seq(1, 2, 3), 3, 2),
    (Seq(3, 2, 1), 3, 2),
    (Seq(1), 1, 0),
    (util.Random.shuffle(1 to 100), 100, 99),
    (Seq(1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 4), 4, 11)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (postions: Seq[Int], width: Int, result: Int) => {
      FrogPositionsTime.solve(postions, width) shouldBe result
    }
    }
  }
}