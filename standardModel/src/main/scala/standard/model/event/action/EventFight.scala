package standard.model.event.action

import standard.model.event.EventAction
import warrior.fight.FighterWarrior

/**
 * * Created by rds on 18/05/15.
 */
trait EventFight extends EventAction {

  def eventDone(fighter: FighterWarrior, eventOwner: FighterWarrior): Boolean = {
    fighter.die || eventOwner.die
  }
  override def toString : String = "Event Fight"

}
