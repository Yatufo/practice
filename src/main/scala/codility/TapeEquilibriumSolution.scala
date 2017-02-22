package codility


object TapeEquilibriumSolution {
  def solve(input: Seq[Int]): Int = {
    var minDiff = Double.MaxValue

    var left: Double = 0
    var right: Double = input.sum
    for (i <- 0 until input.length - 1) {
      left = left + input(i)
      right = right - input(i)
      val diff = math.abs(left - right)
      minDiff = if (diff < minDiff) diff else minDiff
    }

    minDiff.toInt
  }
}
