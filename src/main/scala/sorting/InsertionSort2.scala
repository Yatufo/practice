package sorting



object InsertionSort2 {

  def solve(numbers: Array[Int]): Array[Int] = {
    var results = numbers

    for(i <- 1 to numbers.length - 1){
      results = solve(results, i)
    }

    results
  }

  def solve(numbers: Array[Int], last:Int ) = {

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
    val sc = new java.util.Scanner(System.in);
    val cases = sc.nextInt();
    for (c <- 1 to cases){
      val length = sc.nextInt();
      var numbers = new Array[Int](length)

      for (i <- 0 to length - 1) {
        numbers(i) = sc.nextInt();
      }

      solve(numbers)
    }
  }

}