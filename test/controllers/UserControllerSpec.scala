package controllers

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

class UserControllerSpec extends Specification {
  "#initEntry" should {
    "should status OK" in {
      val result = controllers.UserController.initEntry(FakeRequest())
      status(result) must equalTo(OK)
    }
  }
}
