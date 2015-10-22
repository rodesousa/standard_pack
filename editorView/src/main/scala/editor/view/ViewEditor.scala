package editor.view

import editor.controller.ControllerEditor
import editor.view.listener.ListenerEditor
import editor.view.panel.PanelEditor
import standard.view.swing.View
import standard.view.swing.fight.InfoFIght
import standard.view.swing.panel.{PanelFight, PanelHome}

class ViewEditor(_controller: ControllerEditor) extends View(_controller) {
  val controller = _controller
  val model = controller.model
  var panelGame = new PanelEditor(model)
  val keyboardListener = new ListenerEditor(this)
  val keyboardFightListener = null
  val viewFight = new InfoFIght(model.modelFight)
  val panelFight = new PanelFight(viewFight)
  val panelHome = new PanelHome
  this.init()

  def initFight: Unit = ???

  def deleteFight: Unit = ???
}