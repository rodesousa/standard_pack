package view.warrior.listener

import java.awt.event.KeyEvent

import controller.warrior.fight.ControllerFightWarrior
import view.standard.listener.ListenerFight
import view.warrior.ViewWarrior
import view.warrior.fight.zone.AreaAction

/**
 * * Created by rds on 22/05/15.
 */
class ListenerFightWarrior(view: ViewWarrior, controllerFight: ControllerFightWarrior) extends ListenerFight {

  def keyPressed(keyEvent: KeyEvent) {
    if (controllerFight.lifeAction(keyEvent.getKeyCode)) {

      keyEvent.getKeyCode match {
        case KeyEvent.VK_RIGHT | KeyEvent.VK_LEFT | KeyEvent.VK_UP | KeyEvent.VK_DOWN =>
          this.move(keyEvent.getKeyCode.toString)

        case KeyEvent.VK_ENTER =>
          view.panelFight.viewModelFight.areaCurrent match {
            case e: AreaAction => controllerFight.resolveFight(view.panelFight.viewModelFight.areaAction.elementCurrent.get)
            case _ => this.move(KeyEvent.VK_RIGHT.toString)
          }

        case _ => ()
      }
    }

    view.panelFight.updateUI()

    // FIGHT DONE ?
    if (controllerFight.fightIsItDone()) {
      view.removeListenerFight()
    }

  }

  def move(deplacement: String): Unit = {
    view.panelFight.viewModelFight.move(deplacement)
  }

  def keyTyped(keyEvent: KeyEvent) {
  }

  def keyReleased(keyEvent: KeyEvent) {
  }

}
