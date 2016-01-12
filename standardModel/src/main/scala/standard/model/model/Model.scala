package standard.model.model

import standard.model.dialogue.Dialogue
import standard.model.fight.ModelFight
import standard.model.map.Map
import standard.model.perso.action.Move
import standard.model.perso.job.Personnage
import standard.resources.Variables

import scala.collection.mutable

abstract class Model(_currentMap: Map, _currentPerso: Move) {
  var stateGame = Variables.EVENT_NONE
  var dialogue: Option[Dialogue] = None

  //  def etatMaps: mutable.HashMap[String, Map]

  def etatCompagnons: mutable.HashMap[String, Personnage]

  def currentMap: Map

  def currentPerso: Personnage with Move

  def modelFight: ModelFight
}