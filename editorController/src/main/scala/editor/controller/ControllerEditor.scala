package editor.controller

import standard.model.Model

abstract class ControllerEditor{
  def model : Model
  initGame

  def initGame = ???
  
  def move(indication : String) = model.currentPerso canDo(model,indication)
  
  //TODO
  def action() = ???
}