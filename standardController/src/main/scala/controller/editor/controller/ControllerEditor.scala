package controller.editor.controller

import controller.standard.Controller
import controller.standard.fight.ControllerFight
import controller.standard.resolver.Resolver
import editor.model.ModelEditor

class ControllerEditor(_model: ModelEditor) extends Controller(_model) {
  def model = _model

  val controllerFight = new ControllerFight {}

  val resolver = new Resolver {}

  def writeZoneWalking() {
    val x = model.currentPerso.x
    val y = model.currentPerso.y

    if ( ! model.list.contains((x,y))) {
      model.list = (x,y) :: model.list
    }
    
  }

}
