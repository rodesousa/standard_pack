package standard.model.map

import scala.io.Source

class EtatMap(_nomFichier: String) {
  val donneeFichier = Source.fromFile(_nomFichier).getLines()
  val img = donneeFichier.find(_.startsWith("img=")).get.replace("img=", "")
  val key = donneeFichier.find(_.startsWith("key=")).get.replace("key=", "")
  // on prend un string:  "i j; ii jj; iii jjj"
  // on split en ; et en espace
  // pour tous les (i,j) on construit un Array(Tuple(Int,Int))
  val possitionOccuped = donneeFichier.find(_.startsWith("zoneWalking=")).get.replace("zoneWalking=", "").split(";").
    map(_.split("\\s")).map(a => (a(0).toInt, a(1).toInt)).toList
}