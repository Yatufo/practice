package codility

object FrogPositionsTime {


  def solve(positions: Seq[Int], width: Int) = {
    val CANT_CROSS = -1

    if(positions.size < width)
      CANT_CROSS
    else {
      var minimum = -1
      val leafs = scala.collection.mutable.HashSet[Int]()
      for (time<-positions.indices){
        val leaf = positions(time)
        if (!leafs.contains(leaf)) {
          leafs += leaf
          if (time > minimum) minimum = time
        }
      }

      if (leafs.size == width) minimum else CANT_CROSS
    }

  }
}
