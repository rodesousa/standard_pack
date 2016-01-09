package controller.warrior.resolver

import controller.standard.resolver.Resolver
import controller.warrior.ControllerWarrior
import standard.model.event.action._
import standard.resources.Variables._

/**
 * Created by rodesousa on 22/10/15.
 */

class ResolverWarrior extends Resolver {

  def resolveEvent(controller: ControllerWarrior) = {
    controller.pipeEvent.eventAction match {
      case e: EventDialogue => this.resolveDialogue(e, controller)
      case e: EventFight => this.resolveFight(controller)
      case e: EventDeplacement => EVENT_DEPLACEMENT
      case e: EventFightDone => EVENT_FIGHT_DONE
      case e: EventDone => resolveDone(controller)
      case _ => EVENT_NONE
    }
  }

  private def resolveFight(controller: ControllerWarrior) = {
    controller.initModelFight()
    EVENT_BEGIN_FIGHT
  }


}
