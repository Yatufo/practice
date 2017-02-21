package strings




object AnagramSolution {

  def solve(word: String) : Int = {
    var result = -1

    if (word.length % 2 == 0) {
      val charCounter = scala.collection.mutable.Map[Char, Int]()
      val middle = word.length / 2

      for (i <- 0 until middle) {
        val key = word.charAt(i)
        val count = charCounter.getOrElse(key, 0) + 1
        charCounter += (key -> count)
      }

      for (i <- middle until word.length) {
        val key = word.charAt(i)
        val count = charCounter.getOrElse(key, 0) - 1
        if (count >= 0)
          charCounter += (key -> count)
      }

      result = charCounter.values.sum
    }

    result
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    for (i <- 0 until n){
      println(solve(sc.next()))
    }
  }
}