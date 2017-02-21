package sorting

object MatrixRotation {


  case class Position(row: Int, column : Int) {
    def +: (add: Position) : Position = {
      Position(this.row + add.row, this.column + add.column)
    }
    def -: (substract: Position) : Position = {
      Position(this.row - substract.row, this.column - substract.column)
    }
  }


  def getNext(position : Position, corner: Position, rows: Int, columns: Int) = {

    var rowStep = 0
    var columnStep = 0
    val relative = position.-:(corner)

    val isLeftSide = relative.column == 0 && relative.row < rows - 1
    if (isLeftSide) {
      rowStep = 1
    } else {
      val isRightSide = relative.column == columns - 1 && relative.row > 0
      if (isRightSide) {
        rowStep = -1
      }
    }

    val isTopSide = relative.row == 0 && relative.column > 0
    if (isTopSide) {
      columnStep = -1
    } else {
      val isBottomSide = relative.row == rows - 1 && relative.column < columns - 1
      if (isBottomSide) {
        columnStep = 1
      }
    }

    relative.+:(corner).+:(Position(rowStep, columnStep))
  }


  def solve(matrix : Array[Array[Int]], R: Int): Array[Array[Int]] ={

    val rowsM = matrix.length
    val columnsN = matrix(0).length

    var result = Array.ofDim[Int](rowsM, columnsN)


    rotate(Position(0,0), rowsM, columnsN)

    def rotate(initial: Position, rows:Int, columns:Int) : Unit = {
      var start = initial
      var rotated = initial

      var fullround = 2 * (rows + columns - 2)

      var steps = R % (fullround)

      for(i <- 1 to steps){
        rotated = getNext(Position(rotated.row, rotated.column), initial, rows, columns)
      }


      for(i <- 1 to fullround){
        result(rotated.row)(rotated.column) = matrix(start.row)(start.column)
        start = getNext(start, initial, rows, columns)
        rotated = getNext(rotated, initial, rows, columns)
      }

      if (rows > 2 && columns > 2 ){
        rotate(Position(initial.row + 1, initial.column + 1), rows - 2, columns - 2)
      }

    }


    result
  }

  def printMatrix(matrix : Array[Array[Int]]): Unit ={
    for(i <- 0 to matrix.length - 1) {
      println(matrix(i).mkString(" "))
    }
  }


  def main(args: Array[String]) {
    val input = getInput()
    var result = solve(input._1, input._2)
    printMatrix(result)
  }

  def getInput() = {
    val sc = new java.util.Scanner(System.in);
    var rowsM = sc.nextInt();
    var columnsN = sc.nextInt();
    var R = sc.nextInt();

    var matrix = Array.ofDim[Int](rowsM, columnsN)

    for (i <- 0 to rowsM - 1) {
      for (j <- 0 to columnsN - 1) {
        matrix(i)(j) = sc.nextInt();
      }
    }

    (matrix, R)
  }

}