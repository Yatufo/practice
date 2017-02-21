package codility


object BinaryGapSolution {


  def getMaximumBinaryGap(n: Int) : Int = {
    var left = n
    var length = 0
    var firstOneFound = false
    var maxLength = 0
    var bits = ""
//    println(s"starting for $n")

    while (left > 0) {
      val bit =  left % 2
      bits = bit + bits
      left = math.floor(left / 2).toInt
//      println(bits, left)


      (bit, firstOneFound) match  {
        case (1, false) => firstOneFound = true
        case (1, true) => {
          maxLength = if (length > maxLength) length else maxLength
          length = 0
        }
        case (0, true) => length += 1
        case _ => ()
      }

    }

    maxLength
  }

}
