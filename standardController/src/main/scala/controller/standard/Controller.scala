package controller.standard

import controller.standard.fight.ControllerFight
import controller.standard.resolver.Resolver
import standard.model.event.Events
import standard.model.model.Model
import standard.model.perso.action.Move
import standard.resources.Variables

abstract class Controller(_model: Model) {

  def model: Model

  val pipeEvent = new Events {}

  def resolver: Resolver

  def controllerFight: ControllerFight

  def move(indication: String, perso: Move) = {
    if (_model.stateGame != Variables.EVENT_FIGHT)
      _model.stateGame = Variables.EVENT_DEPLACEMENT
    perso canDo(_model, indication, model.currentPerso.info.nbrPas)
  }

  def eventDone() {
    _model.stateGame = Variables.EVENT_NONE
  }

  def fightBegin() {
    _model.stateGame = Variables.EVENT_FIGHT
  }

  def fightIsItDone(): Boolean = {
    model.stateGame == Variables.EVENT_FIGHT_DONE
  }

  def fightDone() {
    model.stateGame = Variables.EVENT_FIGHT_DONE
  }

}