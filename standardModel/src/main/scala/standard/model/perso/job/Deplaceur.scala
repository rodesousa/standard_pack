package standard.model.perso.job

import java.awt.Point
import standard.model.fonction.action.deplacement.Mobilite
import standard.model.model.Model
import standard.model.perso.Personnage
import standard.resources.Variables

import scala.annotation.tailrec

/**
 * Created by rodesousa on 20/10/15.
 */

abstract class Deplaceur(_nomFichier: String) extends Personnage(_nomFichier) with Mobilite {
  val pas = info.nbrPas

  def canDo(model: Model, direction: String) {
    direction match {
      case Variables.DIRECTION_LEFT => if (tryHorizontale(model, -1)) toDoHorizontale(-1, direction);
      case Variables.DIRECTION_RIGHT => if (tryHorizontale(model, 1)) toDoHorizontale(1, direction)
      case Variables.DIRECTION_UP => if (tryVerticale(model, -1)) toDoVerticale(-1, direction)
      case Variables.DIRECTION_DOWN => if (tryVerticale(model, 1)) toDoVerticale(1, direction)
    }
  }

  private def tryHorizontale(model: Model, indice: Int): Boolean = {
    @tailrec
    def itrZoneWalking(list: List[Point]): Boolean = {
      list match {
        case head :: tail => if (x + (pas * indice) >= head.x) true else itrZoneWalking(tail);
        case _ => false;
      }
    }
    itrZoneWalking(model.currentMap.walkPossible)
  }

  private def tryVerticale(model: Model, indice: Int): Boolean = {
    @tailrec
    def itrZoneWalking(list: List[Point]): Boolean = {
      list match {
        case head :: tail => if (y + (pas * indice) <= head.y) true else itrZoneWalking(tail)
        case _ => false;
      }
    }
    itrZoneWalking(model.currentMap.walkPossible)
  }

  private def toDoHorizontale(indice: Int, direction: String) {
    if (direction == directionCurrent)
      x += (pas * indice)
    directionCurrent = direction
  }

  def toDoVerticale(indice: Int, direction: String) {
    if (direction == directionCurrent)
      y += (pas * indice)
    directionCurrent = direction
  }

}
