package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def test1 = Action {
    Ok(views.html.Application.test1("Hogehogehogehogehoge"))
  }
  
  def test2 = Action {
    Ok(views.html.Application.test1("てーすと〜２"))
  }
  
}