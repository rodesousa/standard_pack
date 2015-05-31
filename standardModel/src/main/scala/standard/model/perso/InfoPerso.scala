package standard.model.perso

import scala.io.Source

class InfoPerso(_nomFichier: String) {
  val donneeFichier = Source.fromFile(_nomFichier).getLines()
  val folder = donneeFichier.find(_.startsWith("folder=")).get.replace("folder=", "")
  val key = donneeFichier.find(_.startsWith("key=")).get.replace("key=", "")
  val nbrPas = donneeFichier.find(_.startsWith("pas=")).get.replace("pas=", "").toInt
  //  var name = donneeFichier.find(_.startsWith("name=")).get.replace("name=", "")
  var name = ""
}
