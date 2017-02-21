package sorting

import org.scalatest._

class MatrixRotationSpec extends FlatSpec with Matchers {

  val test2x3 = Array(
    Array(1,2,3),
    Array(4,5,6)
  )
  val test2x3R1 = Array(
    Array(2,3,6),
    Array(1,4,5)
  )




  val test4x6 = Array(
    Array(1,  2,  3,  4,  5,  6),
    Array(7,  8,  9,  10, 11, 12),
    Array(13, 14, 15, 16, 17, 18),
    Array(19, 20, 21, 22, 23, 24)
  )

  val test4x6R1 = Array(
    Array(2,  3,  4,  5,  6,  12),
    Array(1,  9,  10,  11, 17, 18),
    Array(7,  8,  14,  15, 16, 24),
    Array(13, 19, 20, 21, 22, 23)
  )


  "rotate a 3x2" should "rotate one step" in {
    MatrixRotation.solve(test2x3, 1) shouldBe test2x3R1
  }
  "rotate a 3x2 " should "loop properly" in {
    MatrixRotation.solve(test2x3, 7) shouldBe test2x3R1
    MatrixRotation.solve(test2x3, 13) shouldBe test2x3R1
  }

  "rotate a 4x6" should "rotate one step" in {
    MatrixRotation.solve(test4x6, 1) shouldBe test4x6R1
  }


}