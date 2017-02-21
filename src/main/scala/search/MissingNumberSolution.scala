package search



object MissingNumberSolution {

  import java.util.Scanner

  def getCount(input: Array[Int]) = {
    val result = new scala.collection.mutable.HashMap[Int, Int]()
    input.foreach(number =>  {
      val count = result.getOrElse(number, 0)
      result.put(number, count + 1)
    })
    result
  }

  def solve(input: Array[Int], other: Array[Int]) = {
    val inputMap = getCount(input)
    val otherMap = getCount(other)

    inputMap.keys.flatMap(key => {
      if (otherMap.getOrElse(key, 0) != inputMap.getOrElse(key, 0)){
        Some(key)
      } else None
    }).toSeq.sorted

  }


  def getArray(sc: Scanner, n: Int) = {
    val input = new Array[Int](n)
    for (j <- 0 until n) {
      input(j) = sc.nextInt()
    }
    input
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val input = getArray(sc, n)
    val m = sc.nextInt()
    val missing = getArray(sc, m)

    println(solve(input, missing).mkString(" "))
  }
}

