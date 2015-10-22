package warrior.fight.technique.impl

import warrior.fight.technique.action.Atack
import warrior.fight.technique.style.SwordStyle
import warrior.fight.technique.{Dan, Technique}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.sword.Sword

/**
 * * Created by rds on 22/05/15.
 */
abstract class DeathStyle extends Technique with SwordStyle {
  val name = "Death Style"
  val maxDa = Dan.deux
  //TODO Refaire les stats
  val lethale = new Atack("Lethale") {
    var str = 100
    var defe = 75
    var agi = 100
    var coef = 1
  }

  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Sword => 1
  }

}
