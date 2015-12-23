package controller.warrior.resolver

import controller.standard.resolver.Resolver
import controller.warrior.ControllerWarrior
import standard.model.event.action.{EventDialogue, EventFight}
import standard.resources.Variables._

/**
 * Created by rodesousa on 22/10/15.
 */

class ResolverWarrior extends Resolver {

  def resolveEvent(controller: ControllerWarrior) =
    controller.pipeEvent.events.current match {
      case e: EventDialogue => this.resolveDialogue(e, controller)
      case e: EventFight => this.resolveFight(controller)
      case _ => EVENT_DEPLACEMENT
    }

  private def resolveFight(controller: ControllerWarrior) = {
    controller.initModelFight()
    EVENT_BEGIN_FIGHT
  }

}
