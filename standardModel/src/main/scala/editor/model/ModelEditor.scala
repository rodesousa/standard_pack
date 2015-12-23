package editor.model

import editor.model.map.MapEditor
import editor.model.perso.job.DeplaceurEditor
import standard.model.model.Model

class ModelEditor(_currentMap: MapEditor, _currentPerso: DeplaceurEditor) extends Model(_currentMap, _currentPerso) {

  //  def etatMaps: HashMap[String, standard.model.map.Map] = ???
  def etatMaps = ???

  val modelFight = null

  //  def etatCompagnons: HashMap[String, PersoEditor] = ???
  def etatCompagnons = ???

  var currentMap = _currentMap

  var currentPerso = _currentPerso

  var mutableZoneWalking = currentMap.possitionOccuped
}
