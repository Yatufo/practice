package sorting

object QuickSort2 {

  def solve(input: Array[Int]): Array[Int] = {
    val n = input.length
    if (n > 1) {
      val p = input(0)
      val (left, right) = input.slice(1, n).partition(_ < p)
      val solution = solve(left) ++ Array(p) ++ solve(right)
      println(solution.mkString(" "))
      solution
    } else {
      input
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val input = new Array[Int](n)
    for (i <- 0 until n)
      input(i) = sc.nextInt

    println(solve(input).mkString(" "))

  }

}
