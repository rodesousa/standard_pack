package standard.model.perso.action

import standard.model.model.Model
import standard.resources.Variables

/**
 * Created by rodesousa on 20/10/15.
 */

// transformation en trait
//todo
trait Move {
  var x = 0
  var y = 0
  var directionCurrent = Variables.DIRECTION_UP

  def canDo(model: Model, direction: String, pas: Int) {
    direction match {
      case Variables.DIRECTION_LEFT => toDoHorizontale(model, -1, direction, pas);
      case Variables.DIRECTION_RIGHT => toDoHorizontale(model, 1, direction, pas)
      case Variables.DIRECTION_UP => toDoVerticale(model, -1, direction, pas)
      case Variables.DIRECTION_DOWN => toDoVerticale(model, 1, direction, pas)
    }
  }

  def toDoHorizontale(model: Model, indice: Int, direction: String, pas: Int) {
    if (tryHorizontale(model, indice, pas) && direction == directionCurrent)
      x += (pas * indice)
    directionCurrent = direction
  }

  private def tryHorizontale(model: Model, indice: Int, pas: Int): Boolean = {
    if (x + (pas * indice) < 0)
      return false
    !model.currentMap.possitionOccuped.contains((x + (pas * indice), y))
  }

  def toDoVerticale(model: Model, indice: Int, direction: String, pas: Int) {
    if (tryVerticale(model, indice, pas) && direction == directionCurrent)
      y += (pas * indice)
    directionCurrent = direction
  }

  private def tryVerticale(model: Model, indice: Int, pas: Int): Boolean = {
    if (y + (pas * indice) < 0)
      return false
    !model.currentMap.possitionOccuped.contains((x, y + (pas * indice)))
  }

}
