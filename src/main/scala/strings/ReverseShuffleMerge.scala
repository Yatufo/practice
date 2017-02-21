package strings


object ReverseShuffleMerge {

  case class SortedElement(id: Char, min: Int, max: Int, index: Option[Int] = None) extends Ordered[SortedElement] {
    def compare(that: SortedElement) = {
      (this.index, that.index) match {
        case (Some(thisIndex), Some(thatIndex)) => thisIndex.compare(thatIndex)
        case _ => {
          val alphabetical = this.id.compare(that.id)
          if (alphabetical > 0) this.max.compare(that.min)
          else this.min.compare(that.max)
        }
      }
    }
  }

  def solve(input: String): String = {

    val positionsMap = scala.collection.mutable.HashMap[Char, List[Int]]()

    for (i <- input.indices) {
      val char = input.charAt(i)
      val positions = positionsMap.getOrElse(char, List.empty[Int]) :+ input.size - i
      positionsMap += (char -> positions)
    }


    val elements: List[SortedElement] = getSortedElements(positionsMap)


    reSort(elements).map(_.id).mkString
  }

  def reSort(elements: List[SortedElement]) = {

    val results = scala.collection.mutable.SortedSet[SortedElement]()


    elements.foreach(element => {

      var foundMin = 0
      val minimun: Int = if (results.nonEmpty ) {
        val filtered = results.filter(r => element.min > r.index.get || element.max > r.index.get).flatMap(_.index)
        if (filtered.nonEmpty) filtered.max else 0
      } else 0

      if (element.min > minimun) {
        foundMin = element.min
      } else if (element.max > minimun) {
        foundMin = element.max
      }

      results += element.copy(index = Some(foundMin))
    })

    results.toList
  }


  def getSortedElements(positionsMap: scala.collection.mutable.HashMap[Char, List[Int]]): List[SortedElement] = {
    var alphabetElements = scala.collection.mutable.SortedSet[SortedElement]()

    positionsMap.keys.foreach(key => {
      val elementPositions = positionsMap.get(key).get
      val n: Int = elementPositions.size
      for (i <- 0 until n / 2) {
        alphabetElements += SortedElement(key, elementPositions(n - 1 - i), elementPositions(i))
      }
    })

    alphabetElements.toList
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    println(solve(sc.next()))
  }
}
