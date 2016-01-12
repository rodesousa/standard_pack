package warrior.perso.job

import standard.model.perso.job.Pnj
import warrior.perso.action.FighterWarrior

/**
 * Created by rodesousa on 12/01/16.
 */

abstract class PnjFighterWarrior(_nomFichier: String) extends Pnj(_nomFichier) with FighterWarrior {

}
