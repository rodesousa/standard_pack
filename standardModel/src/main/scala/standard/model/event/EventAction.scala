package standard.model.event

import standard.model.model.Model

/**
 * * Created by rds on 15/05/15.
 */

abstract class EventAction {

  def list: List[Int]

  def eventDone(model : Model) : Boolean
}
