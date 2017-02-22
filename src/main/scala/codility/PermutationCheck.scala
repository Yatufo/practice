package codility

object PermutationCheck {
  def solve(input: Seq[Int]): Int = {
    if (input.isEmpty)
      0
    else {
      val distinct = scala.collection.SortedSet(input: _*).toSeq
      val isTheRightLength = distinct.last == distinct.size
      val allElementsAreDifferent = distinct.size == input.length
      val firstElementIsOne = distinct.headOption.contains(1)
      if (firstElementIsOne && allElementsAreDifferent && isTheRightLength) 1 else 0
    }
  }

}
