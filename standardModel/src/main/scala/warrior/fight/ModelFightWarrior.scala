package warrior.fight

import standard.model.fight.ModelFight
import warrior.fight.menu.{Ele, EleAction, EleTechnique, MenuFight}
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 21/05/15.
 */
class ModelFightWarrior(_atacker: CharacterFighter, _defenser: CharacterFighter) extends ModelFight{
  val modelMenu = new MenuFight
  var stateEleMenu: Ele = modelMenu.technique
  //TODO peut être val
  var listTechnique: List[EleTechnique] = atacker.techniquesCombat.map(e => new EleTechnique(e, modelMenu.technique))
  var listAction: List[EleAction] = Nil

  def atacker = _atacker
  goodNeighbours(listTechnique)

  def defenser = _defenser

  def addActions(ele: EleTechnique) {
    listAction = ele.tech.listAtk.filter(e => e._1).map(e => new EleAction(e._2, ele))
    goodNeighbours(listAction)
  }

  def goodNeighbours(list: List[Ele]) {
    if (list.size == 1) {
      list.head.next = list.head
      list.head.before = list.head
    }
    else if (list.size == 2) {
      list.head.next = list(1)
      list.head.before = list(1)
      list(1).next = list.head
      list(1).before = list.head
    } else {
      list.head.next = list(1)
      list.head.before = list(2)
      list(1).next = list(2)
      list(1).before = list.head
      list(2).next = list.head
      list(2).before = list(1)
    }
  }

}
