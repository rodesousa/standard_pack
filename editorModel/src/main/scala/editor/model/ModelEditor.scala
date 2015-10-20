package editor.model

import editor.model.map.MapEditor
import editor.model.perso.PersoEditor
import editor.resource.Resources
import standard.model.Model
import standard.model.item.weapon.SimpleSword

class ModelEditor extends Model {

  //  def etatMaps: HashMap[String, standard.model.map.Map] = ???
  def etatMaps = ???

  //  def etatCompagnons: HashMap[String, PersoEditor] = ???
  def etatCompagnons = ???

  var currentMap = new MapEditor

  var currentPerso = new PersoEditor(Resources.PERSONNAGE_NAME) {
    var str = 10
    var defe = 10
    var agi = 10
    var arme = new SimpleSword
    hpMax = 100
    vit = 10
  }

  var list = scala.collection.mutable.Map[Int, Int]()

  def setListToZoneWalking() {
    if (list.contains(currentPerso.x)) {
      if (list(currentPerso.x) < currentPerso.y) list(currentPerso.x) = currentPerso.y
    }
    else list(currentPerso.x) = currentPerso.y
  }

  def writeZoneWalkingMap() {
    list.foreach(println)
    println("-----------------------------------------")
  }
}