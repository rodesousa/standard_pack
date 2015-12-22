package editor.model.perso

import editor.model.perso.job.DeplaceurEditor
import standard.model.fight.Fighter

/**
 * Created by rodesousa on 20/10/15.
 */

abstract class PersoEditor(_nomFichier: String) extends DeplaceurEditor(_nomFichier) with Fighter {

}
