package strings

import scala.util.control.Breaks


object SteadyGeneSolution {

  // ACTG - 65 67 84 71
  val MAX_ELEMENTS: Int = 3
  val elements = "ACGT".getBytes()
  val ELEMENT_A = elements(0)
  val ELEMENT_C = elements(1)
  val ELEMENT_G = elements(2)
  val ELEMENT_T = elements(3)

  def getIndex(element : Byte): Int = {
    element match {
      case ELEMENT_A => 0
      case ELEMENT_C => 1
      case ELEMENT_G => 2
      case ELEMENT_T => 3
    }
  }


  def getCurrentExcesses(wordBytes: Array[Byte]) : Array[Int] ={
    val counter = decode(wordBytes)
    val excesses = Array(0,0,0,0)
    val average = wordBytes.length / 4

    for (i <- 0 to MAX_ELEMENTS)  {
      val diff = counter(i) - average
      val isOverTheAverage = diff > 0
      if (isOverTheAverage) {
        excesses(i) += diff
      }
    }

    excesses
  }

  def practicalMinimum(word: String) : Int ={
    val geneChain = word.getBytes()
    val excesses = getCurrentExcesses(geneChain)
    var minimum = excesses.sum
    var maximum = geneChain.length
    var minimumSolution = maximum
//    val milis = System.currentTimeMillis()
    do {
      val middle = minimum + math.ceil((maximum - minimum) / 2).toInt

      if (isSolution(middle, geneChain, excesses)){
        maximum = middle
        if (middle < minimumSolution) minimumSolution = middle
      } else {
        minimum = middle + 1
      }

    }while (minimum < maximum)

//    println((System.currentTimeMillis() - milis) / 1000)
    minimumSolution
  }


  def isSolution(minimum: Int, geneChain: Array[Byte], excesses: Array[Int]): Boolean = {
    var subchainStart = 0
    var subchainEnd = minimum
    var distance = 0
    var found = false
    var hasNext = true


    var decodedChain = decode(geneChain.slice(subchainStart, subchainEnd))


    do {


      distance = getDistance(excesses, decodedChain)

      subchainStart += distance
      subchainEnd += distance

      hasNext = subchainEnd < geneChain.length

      if (hasNext) {
        val previous = geneChain.slice(subchainStart - distance, subchainStart)
        val next = geneChain.slice(subchainEnd - distance, subchainEnd)

        decodedChain = add(decodedChain, decode(next))
        decodedChain = substract(decodedChain, decode(previous))
      }

      found = (0 == distance)

    } while (!found && hasNext)

    found
  }

  def substract(left: Array[Int], right: Array[Int]) = {
    left zip right map{case(a, b) => a - b}
  }

  def add(left: Array[Int], right: Array[Int]) = {
    left zip right map{case(a, b) => a + b}
  }

  def getDistance(containee: Array[Int], container: Array[Int]): Int = {
    var distance = 0
    for (i <- 0 to MAX_ELEMENTS){
      val diff = containee(i) - container(i)
      distance += (if (diff < 0) 0 else diff)
    }

    distance
  }

  def decode(wordBytes: Array[Byte]): Array[Int] = {
    val counter = Array(0,0,0,0)

    for (letter <- wordBytes) {
      val index = getIndex(letter)
      counter(index) += 1
    }

    counter
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val length = sc.nextInt()
    val word = sc.next()
    println(practicalMinimum(word))
  }
}
