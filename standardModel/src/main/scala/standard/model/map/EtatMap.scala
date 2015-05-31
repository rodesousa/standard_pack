package standard.model.map

import scala.io.Source
import java.awt.Point

abstract class EtatMap(_nomFichier: String) {
  val donneeFichier = Source.fromFile(_nomFichier).getLines()
  val img = donneeFichier.find(_.startsWith("img=")).get.replace("img=", "")
  val key = donneeFichier.find(_.startsWith("key=")).get.replace("key=", "")
  val zoneWalking = List(new Point(0, 1000))

}