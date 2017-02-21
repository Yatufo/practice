package strings

import scala.collection.mutable


object GemeStoneSolution {

  def solve(rocks: Array[String]) : Int = {
    val gems = mutable.Set("abcdefghijklmnopqrstuvwxyz".getBytes :_*)
    rocks.foreach(rock => {
      gems.foreach(gem => {
        if (!rock.getBytes.contains(gem)) gems -= gem
      })
    })

    return gems.size
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val rocks = new Array[String](n)
    for(i <- 0 until n){
      rocks(i) = sc.next
    }
    println(solve(rocks))

  }

}
