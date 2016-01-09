package standard.model.event.action

import standard.model.event.EventAction
import standard.model.model.Model
import standard.resources.Variables

/**
 * Created by rodesousa on 29/10/15.
 */
trait EventDeplacement extends EventAction{

  def eventDone(model : Model) = true
  val list = Variables.listDeplacement
  override def toString : String = "Event Deplacement"

}
