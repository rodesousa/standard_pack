package editor.controller

import controller.standard.Controller
import editor.model.ModelEditor

class ControllerEditor(_model: ModelEditor) extends Controller(_model) {
  val model = _model
}