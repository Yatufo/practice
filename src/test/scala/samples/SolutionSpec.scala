package samples

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class SolutionSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Array(1,2,3,4,-1,-2,-15,8), 10),
    (Array(-1,-2,-3,1,2,3,-1,-2,-3,2,3,4,-1,-2,-3), 9),
    (Array(-1,-2,-3), -1),
    (Array(-1), -1),
    (Array(1), 1),
    (Array(1, 2), 3),
    (Array(-1, 2), 2),
    (Array(-1, -2, 3, 3, -5, -6,-8, 9, 25, -1,-2,4), 35))

  "Quick sort" should "sort the basic" in {
    forAll(testCases) { (input: Array[Int], result: Int) =>
      Solution.solution(input, 4) shouldBe result
    }
  }


}