package controller.warrior

import controller.standard.Controller
import controller.warrior.fight.ControllerFightWarrior
import controller.warrior.resolver.ResolverWarrior
import standard.model.map.cellule.Cellule
import standard.resources.Variables._
import warrior.fight.ModelFightWarrior
import warrior.model.ModelWarrior
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 07/05/15.
 */

class ControllerWarrior(_model: ModelWarrior) extends Controller(_model) {

  //  val arrayResolveEvent = new mutable.HashMap[HaveEvent, Int]
  val resolver = new ResolverWarrior
  var controllerFight = new ControllerFightWarrior(this)

  def initModelFight() = {
    val defenser = pipeEvent.events.get match {
      case e: CharacterFighter => e
    }
    model.modelFight = new ModelFightWarrior(model.currentPerso, defenser)
    controllerFight.modelFight = model.modelFight
  }

  //RESOLUTION ENTIERE DES EVENTS
  def resolveAll() = {
    _model.stateGame match {

      case EVENT_FIGHT_DONE =>
        _model.stateGame = EVENT_NONE

      //Partie pour tout event autre que le combat
      case EVENT_NONE | EVENT_DEPLACEMENT =>
        val cel = extractEvent()
        if (cel.isDefined && cel.get.event.isDefined)
          pipeEvent.events = cel.get.event
        else if (DEBUG)
          println("Pas d'event")

      case _ => ()
    }

    if (pipeEvent.events.isDefined) {
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
    pipeEvent.events.get.current.get.eventDone(model)
  }

  def model = _model

  //On regarde si dans la case en face du celle du perso current, il y a un event. Si oui on l'ajoute
  private def extractEvent(): Option[Cellule] = {
    def cellules = _model.currentMap.cellules
    def perso = _model.currentPerso
    def pas = perso.pas
    def x = perso.x
    def y = perso.y

    val list = _model.currentPerso.directionCurrent match {
      case DIRECTION_LEFT => cellules.filter(a => (a.x, a.y) ==(x + (pas * -2), y))
      case DIRECTION_RIGHT => cellules.filter(a => (a.x, a.y) ==(x + (pas * 2), y))
      case DIRECTION_UP => cellules.filter(a => (a.x, a.y) ==(x, y + (pas * -2)))
      case DIRECTION_DOWN => cellules.filter(a => (a.x, a.y) ==(x, y + (pas * 2)))
    }
    list.headOption
  }

  def lifeAction(key: Int): Boolean = _model.stateGame match {
    case EVENT_DEPLACEMENT => listDeplacement.contains(key)
    case EVENT_DIALOGUE => listDialogue.contains(key)
    case EVENT_NONE => true
    case EVENT_FIGHT | EVENT_FIGHT_DONE => listFight.contains(key)
    case _ => false
  }

s}
