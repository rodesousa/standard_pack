package controller.warrior.fight

import controller.standard.fight.ControllerFight
import controller.warrior.ControllerWarrior
import standard.resources.Variables._
import warrior.fight.menu.{EleAction, EleMenu, EleTechnique}
import warrior.fight.{CombatWarrior, ModelFightWarrior}

/**
 * * Created by rds on 19/05/15.
 */
class ControllerFightWarrior(controllerWarrior: ControllerWarrior, _modelFight: ModelFightWarrior) extends ControllerFight{

  val modelFight = _modelFight

  def lifeAction(key: Int) = listFight.filter(_ == key).nonEmpty

  def resolveAll() {
    modelFight.stateEleMenu match {
      case e: EleMenu =>
        modelFight.stateEleMenu = modelFight.listTechnique.head
      case e: EleTechnique => modelFight.addActions(e)
        modelFight.stateEleMenu = modelFight.listAction.head
      case e: EleAction =>
        CombatWarrior.fight(modelFight.atacker, modelFight.defenser, controllerWarrior.model, e.action)
        if (modelFight.atacker.die || modelFight.defenser.die)
          controllerWarrior.model.stateGame = EVENT_FIGHT_DONE
    }
  }

  def move(indication: String) = {
    if (indication == DIRECTION_DOWN) {
      modelFight.stateEleMenu = modelFight.stateEleMenu.next
    }
    if (indication == DIRECTION_UP) {
      modelFight.stateEleMenu = modelFight.stateEleMenu.before
    }
    if (indication == DIRECTION_LEFT) {
      modelFight.stateEleMenu match {
        case e: EleMenu => ()
        case e: EleAction => modelFight.stateEleMenu = e.parent
        case e: EleTechnique => modelFight.stateEleMenu = e.parent
      }
    }
    if (indication == DIRECTION_RIGHT)
      resolveAll()
  }

}