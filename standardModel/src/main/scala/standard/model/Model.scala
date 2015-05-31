package standard.model

import standard.model.dialogue.Dialogue
import standard.model.fight.Fighter
import standard.model.map.Map
import standard.model.perso.Personnage
import standard.resource.Variables._

import scala.collection.immutable.HashMap

abstract class Model() {
  val dialogue = new Dialogue
  var stateGame = EVENT_NONE

  def etatMaps: HashMap[String, Map]

  def etatCompagnons: HashMap[String, Personnage]

  def currentMap: Map

  def currentPerso: Personnage with Fighter
}