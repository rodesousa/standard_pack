package standard.model.fonction.action.deplacement

import java.awt.Point

import standard.model.Model
import standard.model.fonction.action.Action
import standard.resource.Variables._

import scala.annotation.tailrec

trait Deplacement extends Action with Mobilite {
  def canDo(model: Model, direction: String) {
    direction match {
      case DIRECTION_LEFT => if (tryHorizontale(model, -1)) toDoHorizontale(-1, direction);
      case DIRECTION_RIGHT => if (tryHorizontale(model, 1)) toDoHorizontale(1, direction)
      case DIRECTION_UP => if (tryVerticale(model, -1)) toDoVerticale(-1, direction)
      case DIRECTION_DOWN => if (tryVerticale(model, 1)) toDoVerticale(1, direction)
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
    itrZoneWalking(model.currentMap.zoneWalking)
  }

  private def tryVerticale(model: Model, indice: Int): Boolean = {
    @tailrec
    def itrZoneWalking(list: List[Point]): Boolean = {
      list match {
        case head :: tail => if (y + (pas * indice) <= head.y) true else itrZoneWalking(tail)
        case _ => false;
      }
    }
    itrZoneWalking(model.currentMap.zoneWalking)
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