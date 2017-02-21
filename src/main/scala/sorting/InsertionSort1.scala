package sorting



object InsertionSort1 {

  def solve(numbers: Array[Int] ) = {

    val last = numbers.length - 1
    var index = last - 1
    var lastValue = numbers(last)

    var notFound = true
    while (index >= -1 && notFound) {

      notFound = index >= 0 && numbers(index) > lastValue
      numbers(index + 1) = if (notFound) numbers(index) else lastValue

      index -= 1
    }

    numbers
  }



  def main(args: Array[String]) {
    val input = getInput()
    var result = solve(input)
  }

  def getInput() = {
    val sc = new java.util.Scanner(System.in);
    val length = sc.nextInt();
    var numbers = new Array[Int](length)

    for (i <- 0 to length - 1) {
      numbers(i) = sc.nextInt();
    }

    numbers
  }

}