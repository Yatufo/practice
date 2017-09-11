package sorting

import org.scalatest._

class FullCountingSortSpec extends FlatSpec with Matchers {

  val test1 = Seq("0 ab", "6 cd", "0 ef", "6 gh", "4 ij", "0 ab", "6 cd", "0 ef", "6 gh", "0 ij", "4 that", "3 be", "0 to", "1 be", "5 question", "1 or", "2 not", "4 is", "2 to", "4 the")
  val test1Solved = "- - - - - to be or not to be - that is the question - - - -"

  "Insertion sort" should "sort the basic" in {
    FullCountingSort.solve(test1) shouldBe test1Solved
  }
}

object FullCountingSort {

  def solve(input: Seq[String] ) : String = {
    val conveted = for (i <- input.indices) yield {
      val pair = input(i).split(" ", 2)
      val stringValue = if (i >= input.length / 2) pair.tail.headOption.getOrElse("") else "-"
      (pair.head.toInt, stringValue)
    }
    conveted.sortWith(sorting).map(_._2).mkString(" ")
  }

  def sorting(a:(Int, String), b: (Int, String)) : Boolean = a._1 < b._1

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val length = sc.nextInt()
    val pairs =  (1 to length).map(_ => sc.next() + " " + sc.next())

    println(solve(pairs))
  }


}