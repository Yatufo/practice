package strings

object SubstringSolution {


  def getUniqueBytes(longWord : String) : Set[Byte] = {
    var uniqueBytes = Set[Byte]()
    for(l <- longWord.getBytes){
      if (!uniqueBytes.contains(l)){
        uniqueBytes += l
      }
    }

    return uniqueBytes
  }
  def areCommon(left :Set[Byte], right:Set[Byte]) : Boolean = {

    for(l <- left){
        for (r <- right){
          if (l == r){
            return true
          }
        }
    }

    return false
  }

  def areCommon(left :String, right:String) : Boolean = {
    return areCommon(getUniqueBytes(left), getUniqueBytes(right))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val testCases = sc.nextInt()
    for (i <- 1 to testCases){
      val left: String = sc.next()
      val right: String = sc.next()

      println(if (areCommon(left, right)) "YES" else "NO")
    }
  }

}
