package standard.model.event.action

import standard.model.event.EventAction

/**
 * * Created by rds on 16/05/15.
 */
trait EventDialogue extends EventAction {
  def text : String
  def subject : String
}
