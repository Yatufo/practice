package strings

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class SherlockAnagramSpec extends FlatSpec with Matchers {

  val testCases =
    Table(("word", "result"),
      ("abba", 4),
      ("abcd", 0),
      ("ifailuhkqq", 3),
      ("hucpoltgty", 2),
      ("ovarjsnrbf", 2),
      ("pvmupwjjjf", 6),
      ("iwwhrlkpek", 3)
    )


  "Solution" should "should properly is contained" in {
    forAll(testCases) { (word: String, result: Int) =>
      SherlockAnagram.solve(word) shouldBe result
    }

  }


}