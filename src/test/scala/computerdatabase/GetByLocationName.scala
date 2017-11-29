package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random
import com.typesafe.config._
object GetByLocationName {
  val conf = ConfigFactory.load()
  val feedPath = conf.getString("data.feed_path")
  val jsonFileFeeder = jsonFile(feedPath).circular

  val scnGet = scenario("ScenarioGetName")
    .feed(jsonFileFeeder)
    .exec(http("get")
      .get("/getLocationByName/${locationName}"))
}