package search


object ConnectedCellSolution {

  import scala.collection.mutable.{Set, ArrayBuffer}


  case class Position(x: Int, y: Int, value: Int) {

    def isConnected(other: Position): Boolean = {
      val rightValue: Boolean = canConnect && other.value == this.value
      val rightDistance: Boolean = math.abs(this.x - other.x) <= 1 && math.abs(this.y - other.y) <= 1
      rightValue && rightDistance
    }

    def canConnect: Boolean = {
      this.value == 1
    }

    def isInArea(area: Seq[Position]): Boolean = {
      area.exists(_.isConnected(this))
    }
  }

  def areConnected(a :Seq[Position], b: Seq[Position]): Boolean ={
    a.exists(_.isInArea(b))
  }

  def solve(input: Array[Position]) = {

    val areas = new ArrayBuffer[Set[Position]]()

    input.foreach(position => {
      if (position.canConnect && !areas.exists(area => {
        val found = position.isInArea(area.toSeq)
        if (found) area += position
        found
      })) {
        areas += Set(position)
      }
    })


    areas.foreach(a => {
      areas.foreach(b => {
        if (areConnected(a.toSeq, b.toSeq)) a ++= b
      })
    })

    areas.map(_.size).max
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()

    val positions = ArrayBuffer[Position]()
    for(i <- 0 until n){
      for(j <- 0 until m){
        positions += Position(i, j, sc.nextInt())
      }
    }

    println(solve(positions.toArray))

  }
}
