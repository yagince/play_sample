package views

import html.helper.FieldConstructor
import html.boostrapField

/**
 * Created with IntelliJ IDEA.
 * User: yaginatsuki
 * Date: 12/04/29
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */

object BoostrapHelper {
  implicit val boostrapConstructor = FieldConstructor(boostrapField.f)
}
