package standard.controller

import standard.model.Model
import standard.resource.Variables._

abstract class Controller(_model: Model) {
  def model = _model

  def move(indication: String) = {
    if (model.stateGame != EVENT_FIGHT)
      model.stateGame = EVENT_DEPLACEMENT
    model.currentPerso canDo(model, indication)
  }

  def fightDone() {
    model.stateGame = EVENT_NONE
  }

  def fightBegin() {
    model.stateGame = EVENT_FIGHT
  }
}