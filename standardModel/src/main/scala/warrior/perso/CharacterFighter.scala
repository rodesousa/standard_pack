package warrior.perso

import standard.model.perso.job.Deplaceur
import warrior.fight.FighterWarrior
import warrior.fight.technique.action.ActionFight

/**
 * *  Created by rds on 07/05/15.
 */
abstract class CharacterFighter(_nomFichier: String) extends Deplaceur(_nomFichier) with FighterWarrior {

}
