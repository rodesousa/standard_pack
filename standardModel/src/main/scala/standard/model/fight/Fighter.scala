package standard.model.fight

import standard.model.item.weapon.Weapon
import standard.model.stat.{StatCombat, StatHp}
import warrior.fight.technique.action.ActionFight

/**
 * * Created by rds on 20/05/15.
 */
trait Fighter extends StatCombat with StatHp {

   def arme: Weapon

  def atack(actionFight: ActionFight): Int = {
    //TODO Satisfaisant pour l'instant
    str + actionFight.str + arme.str
  }

  def defenseBody: Int = {
    //TODO a refaire
    defe
  }

  def defense(actionFight: ActionFight): Int = {
    //TODO Satisfaisant pour l'instant
    defe + actionFight.defe + arme.defe
  }

}
