package editor.model

import editor.model.map.MapEditor
import editor.resource.Resources._
import standard.model.Model
import standard.model.fight.Fighter
import standard.model.item.weapon.SimpleSword
import standard.model.perso.Personnage

import scala.collection.immutable.HashMap

class ModelEditor extends Model {

  def etatMaps: HashMap[String, standard.model.map.Map] = ???

  def etatCompagnons: HashMap[String, Personnage] = ???

  var currentMap = new MapEditor
  var currentPerso = new Personnage(PERSONNAGE_NAME) with Fighter {
    var str = 10
    var defe = 10
    var agi = 10
    hpMax = 100
    vit = 10
    var arme = new SimpleSword
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