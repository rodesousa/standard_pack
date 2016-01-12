package standard.model.item.vetement

import standard.model.item.Item
import standard.model.stat.StatCombat

trait Vetement extends Item with StatCombat {
  def taille: Int
}
