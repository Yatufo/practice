package strings


object AnagramPalindromeSolution {

  def hasAnagramPalindrome(word: String): Boolean = {
    val allowedOdds = if( word.length % 2 == 1 ) 1 else 0
    var oddLetters = Set[Byte]()

    for(letter <- word.getBytes()) {
      if (oddLetters.contains(letter)){
        oddLetters -= letter
      } else {
        oddLetters += letter
      }
    }

    return oddLetters.size == allowedOdds
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val word = sc.next()
    println(if (hasAnagramPalindrome(word)) "YES" else "NO")

  }



}
