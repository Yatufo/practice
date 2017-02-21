package sorting


object QuickSort1 {

  def solve(input: Array[Int]): Array[Int] = {
    val p = input(0)
    val n = input.length
    val (left, right) = input.slice(1, n).partition(_ < p)

    left ++ Array(p) ++ right
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
