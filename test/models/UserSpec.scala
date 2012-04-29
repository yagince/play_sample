package models

import org.specs2.mutable._
import models.CoreSchema._
import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.H2Adapter
import org.squeryl._
import PrimitiveTypeMode._
import org.specs2.specification.BeforeExample

class UserSpec extends Specification with BeforeExample {
  def before = initializeDB
  /*
  * このテストに意味はないが
  * とりあえず練習だと思って、、、
  * */
  " attributes" should {

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

  trait sampleUser extends org.specs2.mutable.BeforeAfter {
    lazy val user = User("hoge", "foo", "bar")
    def before = { transaction{user.save} }
    def after = { transaction{users.deleteWhere(u => u.id === user.id)} }
  }

  def initializeDB = {
    println("Setting up data.")
    Class.forName("org.h2.Driver")
    SessionFactory.concreteFactory = Some(()=>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:h2:~/example", "sa", ""),
        new H2Adapter)
    )

    inTransaction {
      drop
      create
      printDdl
    }
  }
}
