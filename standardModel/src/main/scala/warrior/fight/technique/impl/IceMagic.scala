package warrior.fight.technique.impl

import warrior.fight.technique.action.Atack
import warrior.fight.technique.style.MagicStyle
import warrior.fight.technique.{Dan, Technique}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.axe.Axe

/**
 * * Created by rds on 22/05/15.
 */
abstract class IceMagic extends Technique with MagicStyle {
  val name = "hache mercenaire"
  val maxDan = Dan.deux
  //TODO Refaire les stats
  val base = new Atack("Ataque base") {
    var str = 10
    var defe = 7
    var agi = 10
    var coef = 1
  }

  //TODO jeu de test
  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Axe => 1
  }

}
