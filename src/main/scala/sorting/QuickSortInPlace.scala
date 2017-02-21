package sorting

object QuickSortInPlace {


  def solve(input: Array[Int]): Array[Int] = {
    solve(input, 0, input.length - 1)
  }

  def solve(input: Array[Int], start: Int, end: Int): Array[Int] = {
    if (start >= 0 && end < input.length && end > start){
      val pivot = input(end)
      var leftMost = -1

      for (i <- start to end) {
        val current = input(i)
        val canSwap = leftMost >= 0

        if (current <= pivot && canSwap) {
          input(i) = input(leftMost)
          input(leftMost) = current
          leftMost += 1
        } else if (current > pivot && !canSwap) {
          leftMost = i
        }
      }

      println(input.mkString(" "))
      // if there was no
      val endLeft: Int = if (leftMost > 0) leftMost - 2 else end - 1
      val startRight: Int = endLeft + 2
      solve(input, start, endLeft)
      solve(input, startRight, end)
    }

    input
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val input = new Array[Int](n)
    for (i <- 0 until n)
      input(i) = sc.nextInt

    solve(input)

  }

}
