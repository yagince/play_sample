package controllers

import play.api.mvc.{Action, Controller}


/**
 * Created with IntelliJ IDEA.
 * User: natsuki
 * Date: 12/05/04
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */

object CalcController extends Controller {
  def index = Action {
    Ok(views.html.Calc.index())
  }
  def plus(first: Int, second: Int) = Action { request =>
    println(request)
    val result = first + second
    println("parameters first:" + first + " second:" + second)
    Ok(views.html.Calc.result(result))
  }
  def minus(first: Int, second: Int) = Action { request =>
    println(request)
    val result = first - second
    Ok(views.html.Calc.result(result))
  }
}
