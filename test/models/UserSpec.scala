package models

import org.specs2.mutable._

class UserSpec extends Specification {
  /*
  * このテストに意味はないが
  * とりあえず練習だと思って、、、
  * */
  " attributes" should {

    trait sampleUser extends org.specs2.mutable.BeforeAfter {
      val user = User("hoge", "foo", "bar")
      def before = { println("-- Before") }
      def after = { println("-- After") }
    }

    "should has name" in new sampleUser {
      user.name must equalTo("hoge")
    }
    "should has email" in new sampleUser {
      user.email must equalTo("foo")
    }
    "should has password" in new sampleUser {
      user.password must equalTo("bar")
    }
  }
}
