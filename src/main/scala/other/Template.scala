package other

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class TemplateSpec extends FlatSpec with Matchers {

  val testCases = Table(("weights", "floors", "maxWeight", "maxPeople", "result"),
    (Seq(60, 80, 40, 10, 10, 10), Seq(2, 3, 5, 5, 5, 5), 200, 2, 7))

  it should "find the sibling number" in {
    forAll(testCases) { (weights:Seq[Int], floors: Seq[Int], maxWeight: Int, maxPeople: Int, result: Int) => {
      Template.solve(weights, floors, maxWeight, maxPeople) shouldBe result
    }
    }
  }

}

object Template {


  def solve(weights:Seq[Int], floors: Seq[Int], maxWeight: Int, maxPeople: Int): Int = {
0
  }



}