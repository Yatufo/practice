package sorting

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table

class QuickSortInPlaceSpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "result"),
    (Array(1, 3, 9, 8, 2, 7, 5), Array(1, 2, 3, 5, 7, 8, 9)),
    (Array(1, 3, 6, 9, 8, 2, 7, 5), Array(1, 2, 3, 5, 6, 7, 8, 9)),
    (Array(5, 8, 1, 3, 7, 9, 2), Array(1, 2, 3, 5, 7, 8, 9)))

  "Quick sort" should "sort the basic" in {
    forAll(testCases) { (input: Array[Int], result: Array[Int]) =>
      QuickSortInPlace.solve(input) shouldBe result
    }
  }


}