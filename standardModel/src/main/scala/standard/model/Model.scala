package standard.model

import standard.model.perso.Personnage
import standard.resource.Variables
import standard.model.map.Map

import scala.collection.mutable

abstract class Model() {
  var stateGame = Variables.EVENT_NONE

  def etatMaps : mutable.HashMap[String, Map]

  def etatCompagnons : mutable.HashMap[String, Personnage]

  def currentMap : Map

  def currentPerso : Personnage
}