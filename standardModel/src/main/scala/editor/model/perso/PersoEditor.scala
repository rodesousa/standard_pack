package editor.model.perso

import editor.model.perso.action.MoveEditor
import standard.model.perso.job.Personnage

/**
 * Created by rodesousa on 20/10/15.
 */

//todo
// elle sert ??
abstract class PersoEditor(_nomFichier: String) extends Personnage(_nomFichier) with MoveEditor {

}
