package other

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.Tables.Table

class ElevatorSpec extends FlatSpec with Matchers {

  val testCases = Table(("weights", "floors", "maxWeight", "maxPeople", "result"),
    (Seq(60, 80, 40), Seq(2, 3, 5), 200, 2, 5),
    (Seq(40,40,100,80,20), Seq(3,3,2,2,3), 200, 3, 6),
    (Seq(60, 80, 40, 10, 10, 10), Seq(2, 3, 5, 5, 5, 5), 200, 2, 7))

  it should "find the sibling number" in {
    forAll(testCases) { (weights:Seq[Int], floors: Seq[Int], maxWeight: Int, maxPeople: Int, result: Int) => {
      Elevator.solve(weights, floors, maxWeight, maxPeople) shouldBe result
    }
    }
  }

}

object Elevator {


  def solve(weights:Seq[Int], floors: Seq[Int], maxWeight: Int, maxPeople: Int): Int = {

    var personIndex, totalStops = 0
    while(personIndex < weights.length) {

      //Start at the ground floor.
      var peopleInElevator, currentWeight = 0
      val floorsToStop = scala.collection.mutable.Set[Int]()
      while (personIndex < weights.length && peopleInElevator < maxPeople && currentWeight + weights(personIndex) <= maxWeight) {
        currentWeight += weights(personIndex)
        peopleInElevator += 1
        floorsToStop += floors(personIndex)
        personIndex += 1
      }

      totalStops += floorsToStop.size + 1
    }

    totalStops
  }



}