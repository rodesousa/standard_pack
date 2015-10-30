package warrior.fight

import standard.model.fight.Fighter
import warrior.fight.technique.Technique
import warrior.item.weapon.WarriorWeapon

/**
 * * Created by rds on 20/05/15.
 */
trait FighterWarrior extends Fighter {
  def listTechnique: List[Technique]

  def arme: WarriorWeapon

}
