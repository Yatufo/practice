package sorting

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class FraudulentActivitySpec extends FlatSpec with Matchers {

  val testCases = Table(("input", "d", "result"),
    ((1 to 100000).map(_ % 200), 200, 1),
    (Seq(4, 3, 5, 8), 2, 1),
    (Seq(4, 3, 5, 7), 2, 0),
    (Seq(2, 3, 4, 2, 3, 6, 8, 4, 5), 5, 2),
    (Seq(1, 2, 3, 4, 4), 4, 0),
    (Seq(1), 5, 0),
    (Seq(1), 5, 0),
    (Seq(1, 2), 1, 1),
    (Seq(1), 1, 0))

  it should "the whole thing" in {
    forAll(testCases) { (input: Seq[Int], d: Int, result: Int) => {
      FraudulentActivity.solve(input, d) shouldBe result
    }
    }
  }

  val testMedian = Table(("input", "result"),
    (Map(1 -> 1, 2 -> 4, 3 -> 1), 2D),
    (Map(1 -> 3, 2 -> 2, 3 -> 1), 1.5D),
    (Map(1 -> 2, 2 -> 1, 3 -> 1), 1.5D),
    (Map(1 -> 3, 2 -> 1, 3 -> 3), 2D),
    (Map(1 -> 1, 2 -> 1, 3 -> 1), 2D)
  )

  it should "calculate median" in {
    forAll(testMedian) { (input: Map[Int, Int], result: Double) => {
      val other = Array.fill(201)(0)
      input.foreach({ case (k, v) => other(k) = v })

      FraudulentActivity.median(other, input.values.sum) shouldBe result
    }
    }
  }
}

object FraudulentActivity {


  def median(frequencies: Array[Int], length: Int): Double = {
    if (frequencies.isEmpty) 0 else {

      val middle = (length + 1) / 2
      val isLengthEven = length % 2 == 0
      var count, i = 0
      var median, left, right = -1D

      while(median < 0){
        count += frequencies(i)

        if(left < 0 && count >= middle){
          left = i
          right = if (!(isLengthEven && count == middle)) left else right
        }
        else if(0 < left && left < i && frequencies(i) > 0){
          right = i
        }

        if (left >= 0 && right >= 0){
          median = (left + right) / 2
        }

        i += 1
      }

      median
    }
  }


  def solve(input: Seq[Int], d: Int): Int = {
    var count = 0
    val freq = frequencies(input, d)

    for (offset <- 0 until input.length - d) {
      val lastDaysMedian = median(freq, d)

      val today = d + offset
      if (input(today) >= 2 * lastDaysMedian) count += 1

      freq(input(offset)) -= 1
      freq(input(today)) += 1
    }
    count
  }


  private def frequencies(input: Seq[Int], d: Int) = {
    val frequencies = Array.fill(201)(0)
    val groupLength = if (d < input.length) d else input.length

    for (i <- 0 until groupLength)
      frequencies(input(i)) += 1

    frequencies
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val d = sc.nextInt()
    val transactions = (1 to n).map(_ => sc.nextInt())

    println(solve(transactions, d))
  }


}