package warrior.fight.technique.impl

import warrior.fight.technique.action.Atack
import warrior.fight.technique.style.SwordStyle
import warrior.fight.technique.{Dan, Technique}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.sword.Sword

/**
 * * Created by rds on 11/05/15.
 */

abstract class HittenMitsurugiRyu extends Technique with SwordStyle {
  val name = "Hitten Mitsurugi Ryu"
  val maxDan = Dan.dix
  val dragonDivin = new Atack("Dragon divin") {
    var str = 10
    var defe = 10
    var coef = 1
    var agi = 10
  }

  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Sword => 1
  }

}