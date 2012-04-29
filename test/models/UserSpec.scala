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
      user.name must beEqualTo("hoge") // equalToでも同じ
    }
    "should has email" in new sampleUser {
      user.email must beEqualTo("foo")
    }
    "should has password" in new sampleUser {
      user.password must beEqualTo("bar")
    }
  }
}
