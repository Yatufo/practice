package codility

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class BinaryGapSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (1,0), // 1
    (2,0), // 10
    (3,0), // 11
    (17,3),// 10001
    (37,2),// 100101
    (145,3), // 10010001
    (1066056, 5), //100000100010001001000
    (5356345, 3) //10100011011101100111001
  )


  "Solution" should "get the maximum binary gap" in {
    forAll(testCases) { (input:Int, result:Int ) => {
      BinaryGapSolution.getMaximumBinaryGap(input) shouldBe result
    }
  }}
}