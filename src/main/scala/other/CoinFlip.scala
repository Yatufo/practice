package other

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class CoinFlipSpec extends FlatSpec with Matchers {

  val testCases = Table(("values", "result"),
    (Array(1,0,1,0,1), 3),
    (Array(0,0,1,0,1,0,1,1,1, 0, 0), 5),
    (Array(0,0,1,0,0,0,1,1,1, 0,0), 4),
    (Array(0,0,1,0,0,0,1,1,1), 4),
    (Array(1,1,0,1,0,0), 4),
    (Array(1,0,0,0,1,1,1), 4),
    (Array(1,0), 2),
    (Array(0,1), 2)
  )

  it should "find the sibling number" in {
    forAll(testCases) { (values:Array[Int], result: Int) => {
      CoinFlip.solve(values) shouldBe result
    }
    }
  }

}

object CoinFlip {

  def solve(values:Array[Int]): Int = {

    var max, previous, current = 0
    for(i <- values.indices) {
      if (values(i) == 1) {
        current += 1
      } else {
        previous = current + 1
        current = 0
      }

      val total = previous + current
      max = if (total > max) total else max
    }
    max
  }

}