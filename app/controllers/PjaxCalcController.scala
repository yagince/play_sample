package controllers

import play.api.mvc.{Action, Controller}


object PjaxCalcController extends Controller {
  def index = Action { implicit request =>
    Ok(views.html.PjaxCalc.index())
  }

  def plus(first: Int, second: Int) = Action { implicit request =>
    println(request)
    Ok(views.html.PjaxCalc.result(first + second))
  }

  def minus(first: Int, second: Int) = Action { implicit request =>
    println(request)
    Ok(views.html.PjaxCalc.result(first - second))
  }
}
