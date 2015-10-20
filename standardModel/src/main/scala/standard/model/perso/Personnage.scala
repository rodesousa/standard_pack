package standard.model.perso

import standard.model.perso.corps.Corps

abstract class Personnage(_nomFichier: String) {
  val info = new InfoPerso(_nomFichier)
  val corps = new Corps
}