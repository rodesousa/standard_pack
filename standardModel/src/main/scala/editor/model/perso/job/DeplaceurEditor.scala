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
      case Variables.DIRECTION_LEFT => if (tryHorizontale(model, -1)) toDoHorizontale(-1, direction);
      case Variables.DIRECTION_RIGHT => if (tryHorizontale(model, 1)) toDoHorizontale(1, direction)
      case Variables.DIRECTION_UP => if (tryVerticale(model, -1)) toDoVerticale(-1, direction)
      case Variables.DIRECTION_DOWN => if (tryVerticale(model, 1)) toDoVerticale(1, direction)
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

}
