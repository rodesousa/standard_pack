package editor.view

import editor.controller.ControllerEditor
import editor.view.listener.ListenerEditor
import editor.view.panel.PanelEditor
import view.swing.standard.View
import view.swing.standard.fight.ViewModelFigth
import view.swing.standard.panel.{PanelFight, PanelHome}

class ViewEditor(_controller: ControllerEditor) extends View(_controller) {
  val controller = _controller
  val model = controller.model
  var panelGame = new PanelEditor(model)
  val keyboardListener = new ListenerEditor(this)
  val keyboardFightListener = null
  val viewFight = new ViewModelFigth(model.modelFight)
  val panelFight = new PanelFight(viewFight)
  val panelHome = new PanelHome
  this.init()

  def initFight: Unit = ???

  def deleteFight: Unit = ???
}