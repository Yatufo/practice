package samples


object Solution {
  def solution(input: Array[Int], n: Int): Int = {

    var maxSum = Int.MinValue
    var maxStart = 0
    var maxEnd = 0

    var partialSum = 0
    var partialStart = 0
    var partialEnd = 0


    var previousDirection = 0

    for(i<-input.indices) {
      val current = input(i)
      val direction = if (current > 0 || (previousDirection > 0 && current == 0)) 1 else -1

      partialSum += current
      println(current, partialSum, maxSum, direction)

      if (current > maxSum) {
        maxStart = i - 1
        maxEnd = partialStart
        maxSum = current
      }

      if (direction != previousDirection && i > 0) {
        if (direction < 0) {
          if (partialSum >= maxSum) {
            maxSum = partialSum
            maxStart = partialStart
            maxEnd = i - 1
          }
        } else {
          if (partialSum <= maxSum) {
            partialStart = i - 1
            partialEnd = partialStart
            partialSum = 0
          }
        }
      }

      previousDirection = direction
    }

    maxSum
  }
}
