package models

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.json.Writes._

case class PostData(msg :String, date: String)

package object formats {
  implicit object PostDataFormat extends Format[PostData] {
    def reads(json: JsValue): PostData = PostData((json \ "msg").as[String], (json \ "date").as[String])
    def writes(postData: PostData):JsValue = JsObject(List("msg" -> JsString(postData.msg), "date" -> JsString(postData.date)))
  }
}