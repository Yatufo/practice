package codility

object MissinIntegerSolution {
  def solve(input: Seq[Int]) : Int = {
    val elements = scala.collection.SortedSet(input: _*).filter(_ > 0).toSeq

    var start = 0
    var end = elements.length - 1
    if(elements.isEmpty || elements(start) > 1)
      return 1
//    println(s"starting with: $input, $elements" )

    while (start < end) {
      val middle = start + math.floor((end - start) / 2).toInt
      val firstPartElementsDiff = elements(middle) - elements(start)
      val secondPartElementsDiff = elements(end) - elements(middle)

      val isInTheFirstPart = firstPartElementsDiff > middle - start
      val isInTheSecondPart = secondPartElementsDiff > end - middle

//      println("split ", start, middle, end)

      if (isInTheFirstPart) {
//        println("first part ", firstPartElementsDiff, isInTheFirstPart)
        start = start
        end = middle
      } else if (isInTheSecondPart){
//        println("second part ", secondPartElementsDiff, isInTheSecondPart)
        end = if (middle == start) start else end
        start = middle
      } else {
//        println("not found part")
        start = end
      }

    }

    elements(start) + 1
  }
}
