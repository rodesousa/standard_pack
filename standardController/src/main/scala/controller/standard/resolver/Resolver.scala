package controller.standard.resolver

import controller.standard.Controller
import standard.model.event.action.{EventDialogue, EventFight}
import standard.resources.Variables._
import warrior.perso.CharacterFighter

/**
 * Created by rodesousa on 22/10/15.
 */
abstract class Resolver {

  def resolveEvent(controller: Controller): String =
    controller.pipeEvent.events.current match {
      case e: EventDialogue => resolveDialogue(e)
      case e: EventFight => resolveFight(controller)
    }

  //resouds les fights
  def resolveFight(controller: Controller): String = {
    this.initControllerFight(controller)
    EVENT_BEGIN_FIGHT
  }

  def initControllerFight(controller: Controller) {
    val defenser = controller.pipeEvent.events match {
      case e: CharacterFighter => e
    }

    // Partie car on ne peut pas implementer un val
    //    controller.controllerFight = new ControllerFight() {
    //      val modelFight = null
    //    }
    ???
  }

  //resoud les dialogues
  def resolveDialogue(e: EventDialogue) = EVENT_DIALOGUE
}
