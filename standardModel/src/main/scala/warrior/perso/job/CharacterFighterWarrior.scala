package warrior.perso.job

import standard.model.perso.action.Move
import standard.model.perso.job.Personnage
import warrior.perso.action.FighterWarrior

/**
 * *  Created by rds on 07/05/15.
 */
abstract class CharacterFighterWarrior(_nomFichier: String) extends Personnage(_nomFichier) with Move with FighterWarrior {

}
