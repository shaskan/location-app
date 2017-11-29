package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.feeder.Record
import scala.util.Random
import com.typesafe.config._

object DeleteLocation {
private def randomString = Random.alphanumeric.take(2).mkString

  private def newLocation =  s"""{
    "locationName":"$randomString"
  }"""
    val conf = ConfigFactory.load()
   val feedPath = conf.getString("data.feed_path")
val jsonFileFeeder = jsonFile(feedPath).circular

    val scndelete = scenario("ScenarioDeleteLocation")
  //  .feed(jsonFileFeeder)
    .exec(http("post")
       .post("/")
  		.header("Content-Type", "application/json")
//       .body(StringBody("""{"locationName": "${locationName}"}"""))
//      .asJSON)
		//.body(StringBody( session => generateJson(session))).asJSON
  		.body(StringBody(newLocation)).asJSON
	  .check(jsonPath("$.locationId").saveAs("taskId")))
    .exec(http("delete")
      .delete("/${taskId}")
      .header("Content-Type", "application/json")
      .asJSON
      .check(status is 200))
      
}