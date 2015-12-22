package editor

import controller.editor.controller.ControllerEditor
import editor.model.ModelEditor
import view.editor.ViewEditor

object Launcher {
  def main(args: Array[String]) {
    val model = new ModelEditor
    val controller = new ControllerEditor(model)
    new ViewEditor(controller)

  }
}
