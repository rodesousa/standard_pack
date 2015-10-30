package view.swing.warrior.listener

import java.awt.event.{KeyEvent, MouseEvent}

import controller.warrior.fight.ControllerFightWarrior
import view.swing.standard.listener.ListenerFight
import view.swing.warrior.ViewWarrior
import view.swing.warrior.fight.zone.AreaAction

/**
 * * Created by rds on 22/05/15.
 */
class ListenerFightWarrior(view: ViewWarrior, controllerFight: ControllerFightWarrior) extends ListenerFight {

  def keyPressed(keyEvent: KeyEvent) {
    if (controllerFight.lifeAction(keyEvent.getKeyCode)) {

      if (keyEvent.getKeyCode == KeyEvent.VK_RIGHT || keyEvent.getKeyCode == KeyEvent.VK_LEFT ||
        keyEvent.getKeyCode == KeyEvent.VK_UP || keyEvent.getKeyCode == KeyEvent.VK_DOWN) {
        this.move(keyEvent.getKeyCode.toString)
      }

      else if (keyEvent.getKeyCode == KeyEvent.VK_ENTER) {

        view.panelFight.viewModelFight.areaCurrent match {
          case e: AreaAction => controllerFight.resolveFight(view.panelFight.viewModelFight.areaAction.elementCurrent.get)
          case _ => this.move(KeyEvent.VK_RIGHT.toString)
        }

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

  def keyTyped(keyEvent: KeyEvent) {}

  def keyReleased(keyEvent: KeyEvent) {}

  def mouseExited(mouseEvent: MouseEvent) {}

  def mouseClicked(mouseEvent: MouseEvent) {}

  def mouseEntered(mouseEvent: MouseEvent) {}

  def mousePressed(mouseEvent: MouseEvent) {}

  def mouseReleased(mouseEvent: MouseEvent) {}

}
