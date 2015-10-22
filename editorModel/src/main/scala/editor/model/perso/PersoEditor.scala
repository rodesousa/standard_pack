package editor.model.perso

import standard.model.fight.Fighter
import standard.model.perso.job.Deplaceur

/**
 * Created by rodesousa on 20/10/15.
 */

abstract class PersoEditor(_nomFichier: String) extends Deplaceur(_nomFichier) with Fighter {

}
