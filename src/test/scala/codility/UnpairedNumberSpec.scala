package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class UnpairedNumberSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Seq(9,3,9,3,9,7,9),7),
    (Seq(1,2,3,4,5,6,7,8,9,10,11,1,2,3,4,5,6,7,8,9,10,11,12),12),
    (Seq(9,3,9,3,9,7,9,4,4,4,4,4,4,4,4,4,4,4,4),7)
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input:Seq[Int], result:Int ) => {
      UnpairedNumberSolution.solve(input) shouldBe result
    }
  }}
}