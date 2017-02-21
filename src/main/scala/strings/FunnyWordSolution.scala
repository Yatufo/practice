package strings


object FunnyWordSolution {

  def solve(word: String) = {
    var isFunny = true
    val n: Int = word.length
    var i = 1

    while (isFunny && i < n){
      isFunny = isFunny && math.abs(word.charAt(i) - word.charAt(i - 1)) == math.abs(word.charAt(n - i - 1) - word.charAt(n - i))
      i += 1
    }

    isFunny
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    for (i <- 1 to n){
      println(if (solve(sc.next())) "Funny" else "Not Funny" )
    }
  }

}
