package controllers

import play.api._
import play.api.mvc._

object UserController extends Controller {

  /**
   * ユーザー登録初期処理.
   */
  def initEntry = Action {
    Ok(views.html.entry("User entry."))
  }

  /**
   * ユーザー登録処理.
   */
  def submitEntry = TODO
}
