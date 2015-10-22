package controller.warrior

import controller.standard.Controller
import controller.warrior.fight.ControllerFightWarrior
import controller.warrior.resolver.ResolverWarrior
import standard.model.event.{HaveEvent, StructEvent}
import standard.model.map.cellule.Cellule
import standard.resources.Variables._
import warrior.model.ModelWarrior

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * * Created by rds on 07/05/15.
 */

class ControllerWarrior(_modelWarrior: ModelWarrior) extends Controller(_modelWarrior) {
  val pipeEvent = new StructEvent
  var controllerFight: ControllerFightWarrior = null
  val arrayResolveEvent = new mutable.HashMap[HaveEvent, Int]
  val model = _modelWarrior
  val resolver = new ResolverWarrior

  //RESOLUTION ENTIERE DES EVENTS
  def resolveAll() = {
    if (_modelWarrior.stateGame == EVENT_FIGHT_DONE)
      _modelWarrior.stateGame = EVENT_NONE

    //Partie pour tout event autre que le combat
    if (_modelWarrior.stateGame == EVENT_NONE || _modelWarrior.stateGame == EVENT_DEPLACEMENT) {

      val cel = extractEvent()
      if (cel != null && cel.event != null)
        pipeEvent.haveEvent = cel.event
      else if (DEBUG)
        println("Pas d'event")

    }
    if (pipeEvent.haveEvent != null) {

      _modelWarrior.stateGame = resolver.resolveEvent(this)

      if (DEBUG)
        println(s"ControllerWarrior: L'event est ${_modelWarrior.stateGame}")

      pipeEvent.nextEvent()
    }

    else
      _modelWarrior.stateGame = EVENT_NONE
  }

  def lifeAction(key: Int): Boolean = _modelWarrior.stateGame match {
    case EVENT_DEPLACEMENT => listDeplacement.filter(_ == key).nonEmpty
    case EVENT_DIALOGUE => listDialogue.filter(_ == key).nonEmpty
    case EVENT_NONE => true
    case EVENT_FIGHT | EVENT_FIGHT_DONE => listFight.filter(_ == key).nonEmpty
    case _ => false
  }

  //On regarde si dans la case en face du celle du perso current, il y a un event. Si oui on l'ajoute
  private def extractEvent(): Cellule = {
    @tailrec
    def itrZoneWalking(list: List[Cellule], firstCondition: Int, secondCondition: Int): Cellule = {
      list match {
        case head :: tail =>
          if (firstCondition >= head.x &&
            secondCondition >= head.y) head
          else itrZoneWalking(tail, firstCondition, secondCondition)
        case _ => null
      }
    }
    //On regarde si le prochain move (qui depent de directionCurrent) à dans la cellule un event
    val cellules = _modelWarrior.currentMap.cellules
    _modelWarrior.currentPerso.directionCurrent match {
      case DIRECTION_LEFT => itrZoneWalking(cellules, _modelWarrior.currentPerso.x + (_modelWarrior.currentPerso.pas * -1),
        _modelWarrior.currentPerso.y)
      case DIRECTION_RIGHT => itrZoneWalking(cellules, _modelWarrior.currentPerso.x + (_modelWarrior.currentPerso.pas * 1),
        _modelWarrior.currentPerso.y)
      case DIRECTION_UP => itrZoneWalking(cellules, _modelWarrior.currentPerso.x,
        _modelWarrior.currentPerso.y + (_modelWarrior.currentPerso.pas * -1))
      case DIRECTION_DOWN => itrZoneWalking(cellules, _modelWarrior.currentPerso.x,
        _modelWarrior.currentPerso.y + (_modelWarrior.currentPerso.pas * 1))
    }
  }

  def isFightDone = model.stateGame == EVENT_FIGHT_DONE


  private def removeControllerFight() {
    controllerFight = null
  }
}
