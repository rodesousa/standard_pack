package controller.warrior

import controller.standard.Controller
import controller.warrior.fight.ControllerFightWarrior
import controller.warrior.resolver.ResolverWarrior
import standard.model.event.{HaveEvent, StructEvent}
import standard.model.map.cellule.Cellule
import standard.resources.Variables._
import warrior.fight.ModelFightWarrior
import warrior.model.ModelWarrior
import warrior.perso.CharacterFighter

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * * Created by rds on 07/05/15.
 */

class ControllerWarrior(_model: ModelWarrior) extends Controller(_model) {

  val arrayResolveEvent = new mutable.HashMap[HaveEvent, Int]
  val resolver = new ResolverWarrior
  var controllerFight = new ControllerFightWarrior(this)

  def initModelFight() = {
    val defenser = pipeEvent.events match {
      case e: CharacterFighter => e
    }
    model.modelFight = new ModelFightWarrior(model.currentPerso, defenser)
    controllerFight.modelFight = model.modelFight
  }

  //RESOLUTION ENTIERE DES EVENTS
  def resolveAll() = {
    if (_model.stateGame == EVENT_FIGHT_DONE)
      _model.stateGame = EVENT_NONE

    //Partie pour tout event autre que le combat
    if (_model.stateGame == EVENT_NONE || _model.stateGame == EVENT_DEPLACEMENT) {
      println("EXTRAIT")
      val cel = extractEvent()
      if (cel != null && cel.event != null)
        pipeEvent.events = cel.event
      else if (DEBUG)
        println("Pas d'event")

    }

    if (pipeEvent.events != null) {
      _model.stateGame = resolver.resolveEvent(this)

      if (DEBUG)
        println(s"ControllerWarrior: L'event est ${_model.stateGame}")

      //On regarde si l'event est fini pour passer au suivant
      nextEvent()

    }

    else
      _model.stateGame = EVENT_NONE
  }

  def nextEvent(): Unit = {
    if (eventIsItDone()) {
      pipeEvent.nextEvent()
    }
  }

  def eventIsItDone(): Boolean = {
    pipeEvent.events.current.eventDone(model)
  }

  def model = _model

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
    val cellules = _model.currentMap.cellules
    _model.currentPerso.directionCurrent match {
      case DIRECTION_LEFT => itrZoneWalking(cellules, _model.currentPerso.x + (_model.currentPerso.pas * -1),
        _model.currentPerso.y)
      case DIRECTION_RIGHT => itrZoneWalking(cellules, _model.currentPerso.x + (_model.currentPerso.pas * 1),
        _model.currentPerso.y)
      case DIRECTION_UP => itrZoneWalking(cellules, _model.currentPerso.x,
        _model.currentPerso.y + (_model.currentPerso.pas * -1))
      case DIRECTION_DOWN => itrZoneWalking(cellules, _model.currentPerso.x,
        _model.currentPerso.y + (_model.currentPerso.pas * 1))
    }
  }

  def lifeAction(key: Int): Boolean = _model.stateGame match {
    case EVENT_DEPLACEMENT => listDeplacement.contains(key)
    case EVENT_DIALOGUE => listDialogue.contains(key)
    case EVENT_NONE => true
    case EVENT_FIGHT | EVENT_FIGHT_DONE => listFight.contains(key)
    case _ => false
  }

}
