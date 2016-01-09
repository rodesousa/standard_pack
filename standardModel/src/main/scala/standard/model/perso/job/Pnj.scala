package standard.model.perso.job

import standard.model.event.{HaveEvent, Events}
import standard.model.perso.Personnage

/**
 * * Created by rds on 13/05/15.
 */
abstract class Pnj(_name: String) extends Personnage(_name) with Events{
  var name = _name
}
