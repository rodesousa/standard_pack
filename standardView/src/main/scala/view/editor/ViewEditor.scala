package view.editor

import controller.editor.controller.ControllerEditor
import view.editor.listener.ListenerEditor
import view.editor.panel.{PanelEditor, PanelFightEditor}
import view.standard.View
import view.standard.panel.PanelHome

class ViewEditor(_controller: ControllerEditor) extends View(_controller) {
  val controller = _controller
  val model = controller.model
  val keyboardListener = new ListenerEditor(this)
  val keyboardFightListener = null
  val panelFight = new PanelFightEditor()
  val panelHome = new PanelHome
  var panelGame = new PanelEditor(model)
  this.init()

  def initFight(): Unit = ???

  def deleteFight(): Unit = ???
}