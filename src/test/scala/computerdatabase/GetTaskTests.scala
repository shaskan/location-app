package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random

object GetTaskTests {

  private def randomString = Random.alphanumeric.take(2).mkString

  private def newLocation = s"""{
    "locationName":"$randomString"
  }"""

  val jsonFileFeeder = jsonFile("src/test/resources/data/LocationFeed.json").circular

  val scnGet = scenario("ScenarioGetName")
    .feed(jsonFileFeeder)
    .exec(http("post")
      .post("/")
      .header("Content-Type", "application/json")
      //.body(StringBody(newCommodity)).asJSON
      //	.body(StringBody("""{"locationName": "${locationName}"}"""))
      .body(StringBody(newLocation)).asJSON
      .check(jsonPath("$.locationId").saveAs("taskId")))
    .exec(http("get")
      .get("/${taskId}")
      .check(jsonPath("$.locationId").saveAs("taskId")))

}