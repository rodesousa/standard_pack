package standard.model.event.action

import standard.model.event.EventAction
import standard.model.model.Model
import standard.resources.Variables

/**
 * Created by rodesousa on 29/10/15.
 */
trait EventDeplacement extends EventAction {

  val list = Variables.listDeplacement

  def eventDone(model: Model) = true

  override def toString: String = "Event Deplacement"

}
