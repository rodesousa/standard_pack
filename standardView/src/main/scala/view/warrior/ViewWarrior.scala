package view.warrior

import _root_.view.standard.View
import _root_.view.standard.panel.PanelHome
import _root_.view.warrior.listener.{ListenerFightWarrior, ListenerWarrior}
import _root_.view.warrior.panel.{PanelFightWarrior, PanelWarrior}
import controller.warrior.ControllerWarrior

/**
 * * Created by rds on 07/05/15.
 */
class ViewWarrior(_controller: ControllerWarrior) extends View(_controller) {

  val controller = _controller
  val model = _controller.model
  val panelGame = new PanelWarrior(model)
  val keyboardListener = new ListenerWarrior(this)
  val panelHome = new PanelHome
  var keyboardFightListener = new ListenerFightWarrior(this, controller.controllerFight)
  var panelFight = new PanelFightWarrior()
  this.init()

  def deleteFight {
    panelFight = null
  }

  def initFight() {
    panelFight.initViewModelFight(_controller.controllerFight)
  }

}
