package sorting

object Test {

  def main(args: Array[String]): Unit = {
    val array = for (i <- 1 to 1000; r = (Math.random * (10000000 - 1)).toInt + 1) yield r
    println(array.mkString(" "))
  }

}
