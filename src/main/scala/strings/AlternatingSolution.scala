package strings


object AlternatingSolution {
  def countDeletions(sentence: String) : Int = {
    val elemental = "AB".getBytes()

    val bits = sentence.getBytes
    var currentBit = bits(0)
    var deletions = 0
    for(i <- 1 to bits.length - 1){
      if (bits(i) == currentBit){
        deletions += 1
      } else {
        currentBit = if (currentBit == elemental(0)) elemental(1) else elemental(0)
      }

    }

    deletions
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val testCases = sc.nextInt();
    for(i <- 1 to testCases){
      val sentence: String = sc.nextLine()
      println(countDeletions(sentence))
    }
  }

}
