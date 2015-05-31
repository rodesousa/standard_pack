package standard.model.fight

import standard.model.item.weapon.Weapon
import standard.model.stat.{StatCombat, StatHp}

/**
 * * Created by rds on 20/05/15.
 */
trait Fighter extends StatCombat with StatHp {
  def arme: Weapon
}
