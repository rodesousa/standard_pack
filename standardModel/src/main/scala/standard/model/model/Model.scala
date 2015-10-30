package standard.model.model

import standard.model.fight.ModelFight
import standard.model.map.Map
import standard.model.perso.Personnage
import standard.model.perso.job.Deplaceur
import standard.resources.Variables

import scala.collection.mutable

abstract class Model() {
  var stateGame = Variables.EVENT_NONE

  def etatMaps: mutable.HashMap[String, Map]

  def etatCompagnons: mutable.HashMap[String, Personnage]

  def currentMap: Map

  def currentPerso: Deplaceur

  def modelFight: ModelFight

}