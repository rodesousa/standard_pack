package editor.model

import editor.model.map.MapEditor
import editor.model.perso.PersoEditor
import standard.model.model.Model

class ModelEditor(_currentMap: MapEditor, _currentPerso: PersoEditor) extends Model(_currentMap, _currentPerso) {

  val modelFight = null
  var currentMap = _currentMap
  var currentPerso = _currentPerso
  var mutableZoneWalking = currentMap.possitionOccuped

  //  def etatMaps: HashMap[String, standard.model.map.Map] = ???
  def etatMaps = ???

  //  def etatCompagnons: HashMap[String, PersoEditor] = ???
  def etatCompagnons = ???
}
