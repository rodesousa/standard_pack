package editor.controller

import editor.model.ModelEditor
import standard.controller.Controller

class ControllerEditor(_model: ModelEditor) extends Controller(_model) {
  val model = _model
}