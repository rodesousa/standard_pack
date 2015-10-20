package standard.controller

import standard.model.Model
import standard.model.perso.job.Deplaceur
import standard.resource.Variables

abstract class Controller(_model: Model) {
  def model : Model

  def move(indication: String, perso : Deplaceur) = {
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