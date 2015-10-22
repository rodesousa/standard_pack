package standard.view.swing.warrior

import controller.warrior.ControllerWarrior
import standard.view.swing.View
import standard.view.swing.panel.PanelHome
import standard.view.swing.warrior.aspect.fight.InfoFightWarrior
import standard.view.swing.warrior.listener.ListenerWarrior
import standard.view.swing.warrior.panel.{PanelFightWarrior, PanelWarrior}

/**
 * * Created by rds on 07/05/15.
 */
class ViewWarrior(_controller: ControllerWarrior) extends View(_controller) {

  val controller = _controller
  val model = _controller.model
  val panelGame = new PanelWarrior(model)
  val keyboardListener = new ListenerWarrior(this)
  val keyboardFightListener = new ListenerWarrior(this)
  var panelFight: PanelFightWarrior = null
  val panelHome = new PanelHome
  this.init()

  def initFight() {
    panelFight = new PanelFightWarrior(new InfoFightWarrior(controller.controllerFight.modelFight))
  }

  def deleteFight {
    panelFight = null
  }

}
