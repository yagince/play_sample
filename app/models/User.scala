package models

import anorm._

/**
 * Created with IntelliJ IDEA.
 * User: yaginatsuki
 * Date: 12/04/29
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 */

case class User(id: Pk[Long], name: String, email: String, password: String)
