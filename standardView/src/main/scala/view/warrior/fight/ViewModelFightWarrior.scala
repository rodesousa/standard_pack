package view.warrior.fight

import controller.warrior.fight.ControllerFightWarrior
import standard.resources.Variables
import view.standard.fight.ViewModelFigth
import view.warrior.fight.zone._
import warrior.fight.technique.Technique

/** "
  * * Created by rds on 21/05/15.
  */

case class TechniqueMenu(_name: String) extends Menu(_name)

case class EscapeMenu(_name: String) extends Menu(_name)

class ViewModelFightWarrior(controllerFight: ControllerFightWarrior) extends ViewModelFigth() {
  val areaMenu = new AreaMenu(new TechniqueMenu("Technique") :: new EscapeMenu("Fuire") :: Nil)
  val areaTechniques = new AreaTechniques(modelFight.atacker.listTechnique)
  var areaCurrent: Area[_] = areaMenu
  var areaAction: AreaAction = null

  def fond = Variables.BLACK

  def mapFight = Variables.MAP_FIGHT

  def curseurImage = Variables.CURSEUR_FIGHT

  def move(deplacement: String) {
    deplacement match {
      case Variables.DIRECTION_LEFT => nextZoneLeft()
      case Variables.DIRECTION_RIGHT => nextZoneRight()
      case e => areaCurrent.move(e)
    }
  }

  def nextZoneLeft() = {
    areaCurrent match {
      case _: AreaMenu => Unit
      case _: AreaTechniques =>
        areaCurrent.mustPrint = false
        areaCurrent = areaMenu
      case _: AreaAction =>
        areaCurrent.mustPrint = false
        areaCurrent = areaTechniques
    }
  }

  def nextZoneRight() {
    areaCurrent match {
      case e: AreaTechniques => initZoneAction(areaTechniques.elementCurrent.get)
      case e: AreaMenu => resolveMenu()
      case _ =>
        areaCurrent = areaTechniques
        areaCurrent.mustPrint = true;
    }
  }

  //on est assure qu'il y a une seule technique
  def initZoneAction(techinque: Technique): Unit = {
    areaAction = new AreaAction(modelFight.atacker.listTechnique.filter(_ == techinque).head.listAtk)
    areaAction.mustPrint = true
    areaCurrent = areaAction
  }

  def modelFight = controllerFight.modelFight

  def resolveMenu(): Unit = {
    areaMenu.elementCurrent.get match {
      case e: EscapeMenu => controllerFight.fightDone()
      case _ =>
        areaCurrent = areaTechniques
        areaCurrent.mustPrint = true
    }
  }
}
