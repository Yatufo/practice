package sorting

object InsertionSortCount {


  def solve(numbers: Array[Int], last: Int): Int = {

    var shifts = 0;
    var index = last - 1
    var lastValue = numbers(last)

    var notFound = true
    while (notFound) {

      notFound = index >= 0 && numbers(index) > lastValue
      numbers(index + 1) = if (notFound) numbers(index) else lastValue

      if (notFound) {
        shifts += 1
      }

      index -= 1
    }

    shifts
  }


  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val cases = sc.nextInt();
    for (c <- 1 to cases){
      val length = sc.nextInt();
      var numbers = new Array[Int](length)
      var shifts = 0
      for (i <- 0 to length - 1) {
        numbers(i) = sc.nextInt();
        if (i > 0){
          shifts += solve(numbers, i)
        }
      }

      println(shifts)
    }
  }

}