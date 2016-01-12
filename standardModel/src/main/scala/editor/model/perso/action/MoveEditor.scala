package editor.model.perso.action

import editor.model.ModelEditor
import standard.model.perso.action.Move
import standard.resources.Variables

/**
 * Created by rodesousa on 22/12/15.
 */

trait MoveEditor extends Move {

  def canDo(model: ModelEditor, direction: String, pas: Int) {
    direction match {
      case Variables.DIRECTION_LEFT => toDoHorizontale(model, -1, direction, pas);
      case Variables.DIRECTION_RIGHT => toDoHorizontale(model, 1, direction, pas)
      case Variables.DIRECTION_UP => toDoVerticale(model, -1, direction, pas)
      case Variables.DIRECTION_DOWN => toDoVerticale(model, 1, direction, pas)
    }
  }

  def toDoHorizontale(model: ModelEditor, indice: Int, direction: String, pas: Int) {
    if (tryHorizontale(model, indice, pas) && direction == directionCurrent)
      x += (pas * indice)
    directionCurrent = direction
  }

  private def tryHorizontale(model: ModelEditor, indice: Int, pas: Int): Boolean = {
    if (x + (pas * indice) < 0)
      return false
    !model.mutableZoneWalking.contains((x + (pas * indice), y))
  }

  def toDoVerticale(model: ModelEditor, indice: Int, direction: String, pas: Int) {
    if (tryVerticale(model, indice, pas) && direction == directionCurrent)
      y += (pas * indice)
    directionCurrent = direction
  }

  private def tryVerticale(model: ModelEditor, indice: Int, pas: Int): Boolean = {
    if (y + (pas * indice) < 0)
      return false
    !model.mutableZoneWalking.contains((x, y + (pas * indice)))
  }

}
