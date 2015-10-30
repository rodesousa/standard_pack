package warrior.fight.technique

import warrior.fight.technique.Dan.dan
import warrior.fight.technique.action.ActionFight
import warrior.fight.technique.style.FightStyle
import warrior.item.weapon.WarriorWeapon

/**
 * * Created by rds on 09/05/15.
 */

case object Dan extends Enumeration {
  type dan = Value
  val un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix = Value
}

trait Technique extends FightStyle {
  var dan = Dan.un

  def name: String

  def maxDan: dan

  def listAtk: List[ActionFight]

  def bonusMalus(warriorWeapon: WarriorWeapon): Int
}
