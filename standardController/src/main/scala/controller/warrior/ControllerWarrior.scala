package controller.warrior

import controller.standard.Controller
import controller.warrior.fight.ControllerFightWarrior
import controller.warrior.resolver.ResolverWarrior
import standard.model.map.cellule.Cellule
import standard.resources.Variables._
import warrior.fight.ModelFightWarrior
import warrior.model.ModelWarrior
import warrior.perso.job.CharacterFighterWarrior

/**
 * * Created by rds on 07/05/15.
 */

class ControllerWarrior(_model: ModelWarrior) extends Controller(_model) {

  val resolver = new ResolverWarrior
  var controllerFight = new ControllerFightWarrior(this)

  //a chaque combat on init le model
  def initModelFight() = {
    val defenser = pipeEvent match {
      case e: CharacterFighterWarrior => e
    }
    model.modelFight = new ModelFightWarrior(model.currentPerso, defenser)
    controllerFight.modelFight = model.modelFight
  }

  def model = _model

  //RESOLUTION ENTIERE DES EVENTS
  def resolveAll() = {
    if (pipeEvent.events.isEmpty) {
      println("Pipe VIDE")
      val cel = extractEvent()
      if (cel.isDefined && cel.get.event.isDefined) {
        pipeEvent.events = cel.get.event
      }
    }

    if (pipeEvent.events.isDefined) {
      println("Pipe PLEIN")
      _model.stateGame = resolver.resolveEvent(this)
    }
    if (pipeEvent.events.isDefined)
      pipeEvent.nextEvent

  }

  //On regarde si dans la case en face du celle du perso current, il y a un event. Si oui on l'ajoute
  private def extractEvent(): Option[Cellule] = {
    def cellules = _model.currentMap.cellules
    def perso = _model.currentPerso
    def pas = perso.info.nbrPas
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

  //on cherche si il y a un nouveau event sinon on passe en deplacement
  def nextEvent(): Unit = {
    //    if (eventIsItDone()) {
    //      if (_model.stateGame.eq(Variables.EVENT_DONE)) {
    //        pipeEvent.events.get.current = pipeEvent.events.get.next.get.current
    //        _model.stateGame = EVENT_DEPLACEMENT
    //        pipeEvent.events = None
    //      }
    //      else
    //        pipeEvent.nextEvent()
    //    }
  }

  // on regarde si l'event en cours est fini
  def eventIsItDone(): Boolean = pipeEvent.events.get.currentEvents(pipeEvent.events.get.eventIndex).eventDone

  // on regarde si c'est possible de faire cette action avec les keys apuuyaient
  // un peu de view...
  def lifeAction(key: Int): Boolean = _model.stateGame match {
    case EVENT_DEPLACEMENT => listDeplacement.contains(key)
    case EVENT_DIALOGUE => listDialogue.contains(key)
    case EVENT_NONE => true
    case EVENT_FIGHT | EVENT_FIGHT_DONE => listFight.contains(key)
    case _ => false
  }

}
