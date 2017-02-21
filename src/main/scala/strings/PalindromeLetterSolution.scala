package strings


object PalindromeLetterSolution {


  val alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ")

  def isPalindrome(word: String): Boolean ={

    val extra = word.length % 2
    val center = word.length / 2

    return word.substring(0, center + extra) == word.substring(center, word.length).reverse

  }

  def countOperations(word: String) : Int = {
    val extra = word.length % 2
    val center = word.length / 2

    val left = word.substring(0, center + extra).getBytes()
    val right = word.substring(center, word.length).reverse.getBytes()
    var operations = 0
    for (i <- 0 to left.length - 1){
      operations += math.abs(left(i) - right(i))
    }

    return operations
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val testCases = sc.nextInt()
    for (i <- 1 to testCases){
      println(countOperations(sc.next()))
    }
  }

}
