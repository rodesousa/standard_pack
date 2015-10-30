package controller.warrior.fight

import controller.standard.fight.ControllerFight
import controller.warrior.ControllerWarrior
import standard.resources.Variables
import standard.resources.Variables._
import warrior.fight.technique.action.ActionFight
import warrior.fight.{ModelFightWarrior, ResolveFight}

/**
 * * Created by rds on 19/05/15.
 */
class ControllerFightWarrior(_controller: ControllerWarrior) extends ControllerFight {

  var modelFight: ModelFightWarrior = null

  def lifeAction(key: Int) = listFight.contains(key)

  def fightIsItDone(): Boolean = _controller.fightIsItDone()

  def eventDone() {
    _controller.eventDone()
  }

  def fightDone() {
    _controller.fightDone()
  }

  def eventIsItDone(): Boolean = {
    _controller.eventIsItDone()
  }

  def resolveFight(action: ActionFight) {

    if (Variables.DEBUG)
      println("Fight")

    ResolveFight.fight(modelFight.atacker, modelFight.defenser, _controller.model, action)

    if (Variables.DEBUG)
      println(s"atacker die ? ${modelFight.atacker.die} defenser die ? ${modelFight.defenser.die}")

    if (eventIsItDone())
      fightDone()
  }

}