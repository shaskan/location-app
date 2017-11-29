package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random
import com.typesafe.config._

object CreateLocation {

  private def randomString = Random.alphanumeric.take(2).mkString

  private def newLocation = s"""{
    "locationName":"$randomString"
  }"""
    
    val conf = ConfigFactory.load()
     val feedPath = conf.getString("data.feed_path_create")
val jsonFileFeeder = jsonFile(feedPath).circular


  val scnCreate = scenario("ScenarioCreateName")
  .feed(jsonFileFeeder)
    .exec(http("post")
      .post("/")
      .header("Content-Type", "application/json")
     .body(StringBody("""{"locationName": "${locationName}"}"""))
      .asJSON
      .check(jsonPath("$.locationId").saveAs("taskId")))
       println("taskId")

}