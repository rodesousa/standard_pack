package controller.standard.resolver

import controller.standard.Controller
import standard.model.dialogue.Dialogue
import standard.model.event.action.{EventDone, EventDialogue, EventFight}
import standard.resources.Variables._


/**
 * Created by rodesousa on 22/10/15.
 */
abstract class Resolver {

  def resolveEvent(controller: Controller): String = {
    controller.pipeEvent.eventAction match {
      case e: EventDialogue => resolveDialogue(e, controller)
      case e: EventFight => resolveFight(controller)
    }
  }

  //resouds les fights
  def resolveFight(controller: Controller): String = {
    EVENT_BEGIN_FIGHT
  }

  //resoud les dialogues
  def resolveDialogue(e: EventDialogue, controller: Controller) = {
    controller.model.dialogue = Some(new Dialogue(e.subject, e.text))
    EVENT_DIALOGUE
  }

  def resolveDone(controller: Controller) = {
    controller.pipeEvent.events.get.eventIndex = 0
    controller.pipeEvent.events = None
    EVENT_DEPLACEMENT
  }
}
