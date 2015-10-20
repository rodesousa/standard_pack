package editor.launcher

import editor.controller.ControllerEditor
import editor.model.ModelEditor
import editor.view.ViewEditor

object Launcher {
  def main(args: Array[String]) {
    val model = new ModelEditor
    val controller = new ControllerEditor(model)
    val view = new ViewEditor(controller)
  }
}
