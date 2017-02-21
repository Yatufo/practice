package search

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import search.ConnectedCellSolution.Position

import scala.collection.mutable.ArrayBuffer

class ConnectedCellSpec extends FlatSpec with Matchers {


  val test1 = Array(
    Array(1, 1, 0, 0),
    Array(0, 1, 1, 0),
    Array(0, 0, 1, 0),
    Array(1, 0, 0, 0))

  val test2 = Array(
    Array(1, 1, 0, 0, 0, 0, 0),
    Array(0, 1, 1, 0, 0, 0, 0),
    Array(0, 0, 1, 1, 1, 0, 0),
    Array(1, 0, 0, 0, 1, 0, 0),
    Array(1, 1, 1, 1, 0, 0, 0))



  val testCases = Table(("input", "result"),
    (test1, 5),
    (test2, 13))

  it should "get the gem stone for the sample" in {
    forAll(testCases) { (input: Array[Array[Int]], result : Int) => {

      val positions = ArrayBuffer[Position]()
      for(i <-input.indices){
        for(j <- input(i).indices){
          positions += Position(i, j, input(i)(j))
        }
      }


      ConnectedCellSolution.solve(positions.toArray) shouldBe result
    }
    }
  }

}