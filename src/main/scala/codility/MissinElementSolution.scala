package codility

object MissinElementSolution {
  def solve(input: Seq[Int]) : Int = {
    val n = (input.length + 1).toDouble
    val expectedSum = (n * (n + 1)) / 2
    (expectedSum - input.map(_.toDouble).sum).toInt
  }
}
