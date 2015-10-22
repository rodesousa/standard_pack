package warrior.perso

import standard.model.perso.job.Deplaceur
import warrior.fight.FighterWarrior
import warrior.fight.technique.action.ActionFight

/**
 * *  Created by rds on 07/05/15.
 */
abstract class CharacterFighter(_nomFichier: String) extends Deplaceur(_nomFichier) with FighterWarrior {
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
