package controller.warrior.resolver

import controller.standard.Controller
import controller.standard.resolver.Resolver
import controller.warrior.ControllerWarrior
import controller.warrior.fight.ControllerFightWarrior
import standard.model.event.action.{EventFight, EventDialogue}
import standard.resources.Variables._
import warrior.fight.ModelFightWarrior
import warrior.perso.CharacterFighter

/**
 * Created by rodesousa on 22/10/15.
 */
class ResolverWarrior extends Resolver {

  def resolveEvent(controller: ControllerWarrior): String =
    controller.pipeEvent.haveEvent.event.current match {
      case e: EventDialogue => println(s"${e} DIAL "); this.resolveDialogue(e)
      case e: EventFight => println(s"${e} FIGHT "); resolveFight(controller)
    }

  //resouds les fights
   private def resolveFight(controller: ControllerWarrior): String = {
    this.initControllerFight(controller)
    EVENT_BEGIN_FIGHT
  }

   private def initControllerFight(controller: ControllerWarrior) {
    val defenser = controller.pipeEvent.haveEvent match {
      case e: CharacterFighter => e
    }
    controller.controllerFight = new ControllerFightWarrior(controller, new ModelFightWarrior(controller.model.currentPerso, defenser))
  }

}
