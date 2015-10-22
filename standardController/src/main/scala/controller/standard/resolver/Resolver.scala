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
    controller.pipeEvent.haveEvent.event.current match {
      case e: EventDialogue => println(s"${e} DIAL "); resolveDialogue(e)
      case e: EventFight => println(s"${e} FIGHT "); resolveFight(controller)
    }

  //resouds les fights
  def resolveFight(controller: Controller): String = {
    this.initControllerFight(controller)
    EVENT_BEGIN_FIGHT
  }

  //resoud les dialogues
  def resolveDialogue(e: EventDialogue) = EVENT_DIALOGUE

  def initControllerFight(controller: Controller) {
    val defenser = controller.pipeEvent.haveEvent match {
      case e: CharacterFighter => e
    }

    // Partie car on ne peut pas implementer un val
    //    controller.controllerFight = new ControllerFight() {
    //      val modelFight = null
    //    }
    ???
  }
}
