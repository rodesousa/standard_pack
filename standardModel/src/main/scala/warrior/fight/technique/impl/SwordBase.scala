package warrior.fight.technique.impl

import warrior.fight.technique.action.Atack
import warrior.fight.technique.style.SwordStyle
import warrior.fight.technique.{Dan, Technique}
import warrior.item.weapon.WarriorWeapon

/**
 * * Created by rds on 11/05/15.
 */
abstract class SwordBase extends Technique with SwordStyle {
  val name = "Simple Technique"

  val maxDan = Dan.cinq

  //TODO Centraliser les atacks ?
  val atack: Atack = new Atack("Atack de base") {
    var str = 1
    var defe = 1
    var agi = 1
    var coef = 1
  }

  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case _ => 0
  }

}
