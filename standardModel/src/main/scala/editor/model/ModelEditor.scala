package editor.model

import editor.model.map.MapEditor
import editor.model.perso.PersoEditor
import editor.resources.Variables
import standard.model.item.weapon.SimpleSword
import standard.model.model.Model

class ModelEditor extends Model {

  //  def etatMaps: HashMap[String, standard.model.map.Map] = ???
  def etatMaps = ???

  val modelFight = null

  //  def etatCompagnons: HashMap[String, PersoEditor] = ???
  def etatCompagnons = ???

  var currentMap = new MapEditor

  var currentPerso = new PersoEditor(Variables.PERSONNAGE_NAME) {
    var str = 10
    var defe = 10
    var agi = 10
    var arme = new SimpleSword
    var hpMax = 100
    var vit = 10
  }

  var mutableZoneWalking = currentMap.possitionOccuped

}
