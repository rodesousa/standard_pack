package standard.view.swing.warrior.aspect.fight

import standard.resources.Variables
import standard.view.swing.fight.InfoFIght
import standard.view.swing.warrior.aspect.fight.menu._
import warrior.fight.ModelFightWarrior

/**
 * * Created by rds on 21/05/15.
 */
class InfoFightWarrior(_model: ModelFightWarrior) extends InfoFIght(_model) {
  val model = _model

  val mapfight = Variables.MAP_FIGHT
  val menu = new ViewMenuFight
  // la coordonnée de la première ligne
  val xFirstLine = menu.technique.x
  val yFirstLine = menu.technique.y
  val xSecondLine = xFirstLine + 118
  val xThirdLine = xSecondLine + 250
  //curseur
  val curseurMenu = new ViewCurseur(Variables.CURSEUR_FIGHT_PATH)
  val curseurTechnique = new ViewCurseur(Variables.CURSEUR_FIGHT_PATH)
  val curseurAction = new ViewCurseur(Variables.CURSEUR_FIGHT_PATH)
  var curseurCurrent = curseurMenu
  //On dit que le curseur commence par technique
  curseurCurrent.ele = menu.technique

  //TODO peut être val
  println('1')
  println(_model.listTechnique)
  println('2')
  println(xSecondLine)
  println('3')
  println(yFirstLine)
  println('4')
  println(menu)
  println('5')
  println(menu.technique)
  println('6')
  var listTechnique = _model.listTechnique.map(e => new ViewEleTechnique(e.tech, xSecondLine, yFirstLine, menu.technique))
  goodY(listTechnique)
  goodNeighbours(listTechnique)

  def goodNeighbours(list: List[ViewEle]) {
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

  var listAction: List[ViewEleAction] = Nil

  def addActions(ele: ViewEleTechnique) {
    //    listAction = ele.tech.listAtk.filter(e => e._1).map(e => new ViewEleAction(e._2, xThirdLine, yFirstLine, ele))
    listAction = _model.listAction.map(e => new ViewEleAction(e.action, xThirdLine, yFirstLine, ele))
    goodY(listAction)
    goodNeighbours(listAction)
  }

  def goodY(list: List[ViewEle]) {
    if (list.size >= 2)
      list(1).y += 20
    if (list.size == 3)
      list(-1).y += 40
  }

}
