package standard.model.event.action

import standard.model.event.EventAction

/**
 * Created by rodesousa on 08/01/16.
 */
trait EventFightDone extends EventAction {

  def eventDone(): Boolean = true

  override def toString : String = "Event Fight Done"

}

