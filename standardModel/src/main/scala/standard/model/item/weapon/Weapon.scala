package standard.model.item.weapon

import standard.model.item.Item
import standard.model.stat.StatCombat

/**
 * * Created by rds on 11/05/15.
 */
trait Weapon extends Item with StatCombat{
  def name : String
}
