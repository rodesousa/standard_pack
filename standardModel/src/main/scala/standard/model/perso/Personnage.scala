package standard.model.perso

import standard.model.fonction.action.deplacement.Deplacement
import standard.model.perso.corps.Corps

abstract class Personnage(_nomFichier: String) extends Deplacement {
  val info = new InfoPerso(_nomFichier)
  val pas = info.nbrPas
  val corps = new Corps
}