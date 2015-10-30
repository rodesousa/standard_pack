package view.swing.warrior

import _root_.view.swing.standard.View
import _root_.view.swing.standard.panel.PanelHome
import _root_.view.swing.warrior.listener.{ListenerFightWarrior, ListenerWarrior}
import _root_.view.swing.warrior.panel.{PanelFightWarrior, PanelWarrior}
import controller.warrior.ControllerWarrior
import warrior.fight.ModelFightWarrior

/**
 * * Created by rds on 07/05/15.
 */
class ViewWarrior(_controller: ControllerWarrior) extends View(_controller) {

  val controller = _controller
  val model = _controller.model
  val panelGame = new PanelWarrior(model)
  val keyboardListener = new ListenerWarrior(this)
  var keyboardFightListener = new ListenerFightWarrior(this, controller.controllerFight)
  var panelFight = new PanelFightWarrior()
  val panelHome = new PanelHome
  this.init()

  def deleteFight {
    panelFight = null
  }

  def initFight() {
    panelFight.initViewModelFight(_controller.controllerFight)
  }

}
