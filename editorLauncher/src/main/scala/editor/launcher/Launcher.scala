package editor.launcher

import editor.model.ModelEditor
import editor.view.ViewEditor

object Launcher {
  def main(args: Array[String]) {
    val model = new ModelEditor
    val view = new ViewEditor(model)
  }
}
