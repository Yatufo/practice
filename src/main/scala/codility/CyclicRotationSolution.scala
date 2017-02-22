package codility


object CyclicRotationSolution {
  def solve(input: Seq[Int], k: Int) = {
    val rotations = k % input.length
    input.takeRight(rotations) ++ input.take(input.length - rotations)
  }
}
