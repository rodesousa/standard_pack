package standard.model.event.action

import standard.model.event.EventAction
import standard.resources.Variables

/**
 * * Created by rds on 16/05/15.
 */
trait EventDialogue extends EventAction {
  val possiblesTouch = Variables.listDialogue

  def text: String

  def subject: String

  override def toString: String = "Event Dialogue"
}
