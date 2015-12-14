package controller.editor.controller

import controller.standard.Controller
import controller.standard.fight.ControllerFight
import controller.standard.resolver.Resolver
import editor.model.ModelEditor
import standard.model.event.StructEvent

class ControllerEditor(_model: ModelEditor) extends Controller(_model) {
  val model = _model

  val controllerFight = new ControllerFight {}

  val resolver = new Resolver {}
}
