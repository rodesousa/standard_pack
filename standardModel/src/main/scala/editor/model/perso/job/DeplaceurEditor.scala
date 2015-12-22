package editor.model.perso.job

import editor.model.ModelEditor
import standard.model.perso.job.Deplaceur
import standard.resources.Variables

/**
 * Created by rodesousa on 22/12/15.
 */
abstract class DeplaceurEditor(_nomFichier: String) extends Deplaceur(_nomFichier) {

  def canDo(model: ModelEditor, direction: String) {
    direction match {
      case Variables.DIRECTION_LEFT => toDoHorizontale(model, -1, direction);
      case Variables.DIRECTION_RIGHT => toDoHorizontale(model, 1, direction)
      case Variables.DIRECTION_UP => toDoVerticale(model, -1, direction)
      case Variables.DIRECTION_DOWN => toDoVerticale(model, 1, direction)
    }
  }

  private def tryHorizontale(model: ModelEditor, indice: Int): Boolean = {
    if (x + (pas * indice) < 0)
      return false
    !model.mutableZoneWalking.contains((x + (pas * indice), y))
  }

  private def tryVerticale(model: ModelEditor, indice: Int): Boolean = {
    if (y + (pas * indice) < 0)
      return false
    !model.mutableZoneWalking.contains((x, y + (pas * indice)))
  }

  def toDoHorizontale(model: ModelEditor, indice: Int, direction: String) {
    if (tryHorizontale(model, indice) && direction == directionCurrent)
      x += (pas * indice)
    directionCurrent = direction
  }

  def toDoVerticale(model: ModelEditor, indice: Int, direction: String) {
    if (tryVerticale(model, indice) && direction == directionCurrent)
      y += (pas * indice)
    directionCurrent = direction
  }

}
