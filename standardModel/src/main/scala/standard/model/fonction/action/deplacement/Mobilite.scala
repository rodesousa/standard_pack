package standard.model.fonction.action.deplacement

import standard.resource.Variables._

/**
 * *  Created by rds on 09/05/15.
 */
trait Mobilite {
  def pas: Int

  var directionCurrent = DIRECTION_UP
  var x = 0
  var y = 0
}
