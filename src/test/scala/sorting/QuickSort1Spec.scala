package sorting

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class QuickSort1Spec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Array(4, 5, 3, 7, 2), Array(3, 2, 4, 5, 7)))

  "Quick sort" should "sort the basic" in {
    forAll(testCases) { (input: Array[Int], result: Array[Int]) =>
      QuickSort1.solve(input) shouldBe result
    }
  }


}