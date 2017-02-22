package codility

import scala.collection.mutable

object UnpairedNumberSolution {
  def solve(input: Seq[Int]) : Int = {
    val unpaired = mutable.Set[Int]()
    input.foreach(element => {
      if (unpaired.contains(element)) unpaired.remove(element) else  unpaired += element
      //println(unpaired, element)
    } )
    unpaired.head
  }

}
