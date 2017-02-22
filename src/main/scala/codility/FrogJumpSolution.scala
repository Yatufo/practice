package codility


object FrogJumpSolution {
  def solve(x: Int, y: Int, d: Int) : Int = {
    math.ceil((y - x).toDouble / d).toInt
  }

}
