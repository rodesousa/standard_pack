package standard.model.perso.job

import standard.model.perso.InfoPerso
import standard.model.perso.corps.Corps
import standard.resources.Variables

abstract class Personnage(_nomFichier: String) {
  val info = _nomFichier match {
    case Variables.NOTIMPLE => new InfoPerso(Variables.PERSONNAGE_NAME)
    case _ => new InfoPerso(_nomFichier)
  }
  val corps = new Corps
}