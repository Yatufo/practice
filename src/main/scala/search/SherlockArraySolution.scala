package search


object SherlockArraySolution {

  def solve(input: Array[Int]): String = {

    var left = 0
    var right = input.sum

    for (i <- input.indices) {
      val previous = if (i > 0) input(i - 1) else 0
      val current = input(i)


      left = left + previous
      right = right - current


      if (right == left) {
        return "YES"
      }

    }
    return "NO"
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val cases = sc.nextInt()

    for (i <- 1 to cases) {
      val n = sc.nextInt()
      val input = new Array[Int](n)
      for (j <- 0 until n) {
        input(j) = sc.nextInt()
      }
      println(solve(input))
    }

  }
}

