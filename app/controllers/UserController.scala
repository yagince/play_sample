package controllers

import play.api._
import play.api.db._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{CoreSchema, User}
import scala.Some

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.{Session}

object UserController extends Controller {

  val userForm: Form[User] = Form(
    // Userフォームマッピング
    mapping(
      "name" -> text(minLength = 4),
      "email" -> email,
      "password" -> tuple("main" -> text(minLength = 6), "confirm" -> text).verifying(
        // パスワードの入力ルール定義
        "error.password.unmatch", passwords => passwords._1 == passwords._2
      )
    ) {
      // Userフォームバインド
      (name, email, passwords) => User(name, email, passwords._1)
    } {
      // Usetフォームアンバインド
      user => Some(user.name, user.email, (user.password, ""))
    }.verifying(
      "This username is not available",
      user => !Seq("admin", "guest").contains(user.name)
    )
  )

  /**
   * ユーザー登録初期処理.
   */
  def initEntry = Action {
    Ok(views.html.entry(userForm))
  }

  /**
   * ユーザー登録処理.
   */
  def submitEntry = Action {implicit request =>
    userForm.bindFromRequest.fold(
      errors => BadRequest(views.html.entry(errors)),
      user => {
        inTransaction {
          CoreSchema.users.insert(user)
          Redirect(routes.UserController.showEntry(user.id))
        }
      }
    )
  }

  def showEntry(id: Long) = Action {implicit request =>
    inTransaction {
      val user = CoreSchema.users.where(u => u.id === id).single
      Ok(views.html.result(user))
    }
  }
}
