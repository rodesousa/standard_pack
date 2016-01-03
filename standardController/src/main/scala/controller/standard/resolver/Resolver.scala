package controller.standard.resolver

import controller.standard.Controller
import standard.model.dialogue.Dialogue
import standard.model.event.action.{EventDialogue, EventFight}
import standard.resources.Variables._
import warrior.perso.CharacterFighter


/**
 * Created by rodesousa on 22/10/15.
 */
abstract class Resolver {

  def resolveEvent(controller: Controller): String =
    controller.pipeEvent.events.get.current match {
      case e: EventDialogue => resolveDialogue(e, controller)
      case e: EventFight => resolveFight(controller)
    }

  //resouds les fights
  def resolveFight(controller: Controller): String = {
    this.initControllerFight(controller)
    EVENT_BEGIN_FIGHT
  }

  def initControllerFight(controller: Controller) {
    val defenser = controller.pipeEvent.events.get match {
      case e: CharacterFighter => e
    }

    // Partie car on ne peut pas implementer un val
    //    controller.controllerFight = new ControllerFight() {
    //      val modelFight = null
    //    }
    ???
  }

  //resoud les dialogues
  def resolveDialogue(e: EventDialogue, controller: Controller) = {
    controller.model.dialogue = Option(new Dialogue(e.subject, e.text))
    EVENT_DIALOGUE
  }
}
