package controller.standard

import controller.standard.fight.ControllerFight
import controller.standard.resolver.Resolver
import standard.model.event.StructEvent
import standard.model.model.Model
import standard.model.perso.job.Deplaceur
import standard.resources.Variables

abstract class Controller(_model: Model) {
  def model: Model

  def pipeEvent: StructEvent

  def resolver: Resolver

  def controllerFight: ControllerFight

  def move(indication: String, perso: Deplaceur) = {
    if (_model.stateGame != Variables.EVENT_FIGHT)
      _model.stateGame = Variables.EVENT_DEPLACEMENT
    perso canDo(_model, indication)
  }

  def fightDone() {
    _model.stateGame = Variables.EVENT_NONE
  }

  def fightBegin() {
    _model.stateGame = Variables.EVENT_FIGHT
  }
}