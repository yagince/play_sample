import play.api._
import play.api.db._
import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.MySQLAdapter

/**
 * Created with IntelliJ IDEA.
 * User: yaginatsuki
 * Date: 12/04/29
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */

object Global extends GlobalSettings {
  override def onStart(app: Application) {
    SessionFactory.concreteFactory = Some( () => connection )
    def connection() = {
      Session.create(DB.getConnection()(app), new MySQLAdapter)
    }
  }
 }
