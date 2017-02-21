package sorting

import org.scalatest._

class InsertionSort2Spec extends FlatSpec with Matchers {

  val test1 = Array(1,5,3,2,4)
  val test1Solved = Array(1,2,3,4, 5)

//  val test2 = Array(1,1,3,3,4,4,2)
//  val test2Solved = Array(1,1,2,3,3,4,4)
//
//  val test3 = Array(1,1,2,3,3,4,4,2)
//  val test3Solved = Array(1,1,2,2,3,3,4,4)
//
//  val test4 = Array(1,1,2,3,3,4,4,9)
//  val test4Solved = Array(1,1,2,3,3,4,4,9)
//
//  val test5 = Array(1,1,2,3,3,4,4,9,9,-9)
//  val test5Solved = Array(-9,1,1,2,3,3,4,4,9,9)


  "Insertion sort" should "sort the basic" in {
    InsertionSort2.solve(test1) shouldBe test1Solved

  }




}