package strings


object SherlockAnagram {



  def getSorted(word: String) = {
    word.getBytes.toSeq.sorted
  }

  def solve(word: String): Int = {

    val maxLength = word.length
    var count = 0
    val pairs = scala.collection.mutable.HashMap[Seq[Byte], Int]()
    for (length <- 1 to maxLength) {
      for (i <- 0 to maxLength - length) {
        val substring = word.substring(i, i + length)
        val key = getSorted(substring)
        val value = pairs.getOrElse(key, 0) + 1
        pairs += key -> value
      }
    }
    pairs.values.map(count => summation(count - 1)).sum
  }

  def summation(n:Int) : Int= {
    n * (n + 1) / 2
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    for (i <- 0 until n){
      println(solve(sc.next()))
    }
  }


}
