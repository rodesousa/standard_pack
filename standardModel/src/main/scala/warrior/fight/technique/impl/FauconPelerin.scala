package warrior.fight.technique.impl

import warrior.fight.technique.action.{Atack, Counter}
import warrior.fight.technique.style.SwordStyle
import warrior.fight.technique.{Dan, Technique}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.sword.Sword

/**
 * * Created by rds on 22/05/15.
 */
abstract class FauconPelerin extends Technique with SwordStyle {
  val name = "Faucon Pelerin"
  val maxDan = Dan.dix
  //TODO Refaire les stats
  val pic = new Atack("Pic") {
    var str = 100
    var defe = 75
    var agi = 100
    var coef = 1
  }
  val rafale = new Counter("Rafale") {
    var str = 100
    var defe = 75
    var agi = 100
    var coef = 1
  }

  //TODO jeu de test
  def bonusMalus(warriorWeapon: WarriorWeapon) = warriorWeapon match {
    case w: Sword => 1
  }

}
