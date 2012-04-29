package models

/**
 * Created with IntelliJ IDEA.
 * User: yaginatsuki
 * Date: 12/04/29
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */

case class User(var name: String,
                var email: String,
                var password: String) extends BaseEntity {
  def this() = this("", "", "")
}
