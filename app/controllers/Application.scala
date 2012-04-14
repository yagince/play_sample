package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.PostData
import models.formats._

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
  
  def hello(id: Int) = Action { request =>
	val name = request.queryString.get("name").flatMap(_.headOption)
    Ok(views.html.Application.hello(id + " : Hello! " + name.getOrElse("default name")));
  }
  
  def jsonTest = Action {
    Ok(Json.toJson("hello"))
  }
  def jsonList = Action {
    Ok(Json.toJson(List(1,2,3)))
  }
  def jsonMap = Action {
    Ok(Json.toJson(Map("hoge" -> "hogeValue", "foo" -> "fooValue")))
  }
  def jsonReturn = Action {
    Ok(Json.toJson(PostData("hoge", "foo")))
  }
  def jsonParse = Action {
    val postJson = """{"msg": "jsonParse", "date": "2012-01-01"}"""
    val result = Json.parse(postJson).as[PostData]
    Ok("result = %s".format(result))
  }
  
}