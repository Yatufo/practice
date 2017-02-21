package strings


object PangramSolution {

  val alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ")
  def isPangram(sentence: String) : Boolean = {
    val lowSentence = sentence.toLowerCase()

    for(letter <- alphabet){
      if(lowSentence.indexOf(letter) < 0){
        return false
      }
    }

    true
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val sentence = sc.nextLine()
    println(if (isPangram(sentence)) "pangram" else "not pangram")
  }



}
