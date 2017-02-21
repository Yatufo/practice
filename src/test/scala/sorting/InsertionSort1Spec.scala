package sorting

import org.scalatest._

class InsertionSort1Spec extends FlatSpec with Matchers {

  val test1 = Array(1,3,4,2)
  val test1Solved = Array(1,2,3,4)

  val test2 = Array(1,1,3,3,4,4,2)
  val test2Solved = Array(1,1,2,3,3,4,4)

  val test3 = Array(1,1,2,3,3,4,4,2)
  val test3Solved = Array(1,1,2,2,3,3,4,4)

  val test4 = Array(1,1,2,3,3,4,4,9)
  val test4Solved = Array(1,1,2,3,3,4,4,9)

  val test5 = Array(1,1,2,3,3,4,4,9,9,-9)
  val test5Solved = Array(-9,1,1,2,3,3,4,4,9,9)


  "Insertion sort" should "sort the basic" in {
    InsertionSort1.solve(test1) shouldBe test1Solved
    InsertionSort1.solve(test2) shouldBe test2Solved
    InsertionSort1.solve(test3) shouldBe test3Solved
    InsertionSort1.solve(test4) shouldBe test4Solved
    InsertionSort1.solve(test5) shouldBe test5Solved
  }




}