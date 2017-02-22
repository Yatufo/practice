package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class FrogJumpSpec extends FlatSpec with Matchers {

  val testCases = Table(("x", "y", "d", "result"),
    (10, 85, 30, 3)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (x: Int, y: Int, d:Int, result: Int) => {
      FrogJumpSolution.solve(x,y,d) shouldBe result
    }
    }
  }
}