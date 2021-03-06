package standard.model.map

import java.awt.Point

import standard.model.map.cellule.Cellule

import scala.collection.mutable

case class Case(point : Point, next : List[Case])

abstract class Map(nomFichier : String) extends EtatMap(nomFichier){
  var cellules: List[Cellule] = Nil
}