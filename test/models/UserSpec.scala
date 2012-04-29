package models

import org.specs2.mutable.Specification

class UserSpec extends Specification {
  /*
  * このテストに意味はないが
  * とりあえず練習だと思って、、、
  * */
  " attributes" should {
    val user = User("hoge", "foo", "bar")
    "should has name" in {
      user.name must equalTo("hoge")
    }
    "should has email" in {
      user.email must equalTo("foo")
    }
    "should has password" in {
      user.password must equalTo("bar")
    }
  }
}
