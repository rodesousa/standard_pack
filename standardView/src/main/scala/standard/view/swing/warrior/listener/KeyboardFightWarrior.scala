package standard.view.swing.warrior.listener

import java.awt.event.{KeyEvent, KeyListener, MouseEvent, MouseListener}
import controller.warrior.fight.ControllerFightWarrior
import standard.view.swing.warrior.ViewWarrior

/**
 * * Created by rds on 22/05/15.
 */
class KeyboardFightWarrior(view: ViewWarrior, controllerFight: ControllerFightWarrior) extends KeyListener with MouseListener {
  //TODO val ?
  def controller = view.controller

  val currentPerso = view.model.currentPerso

  def keyPressed(keyEvent: KeyEvent) {
    if (controller.lifeAction(keyEvent.getKeyCode)) {
      if (keyEvent.getKeyCode == KeyEvent.VK_RIGHT || keyEvent.getKeyCode == KeyEvent.VK_LEFT ||
        keyEvent.getKeyCode == KeyEvent.VK_UP || keyEvent.getKeyCode == KeyEvent.VK_DOWN) {
        controller.move(keyEvent.getKeyCode.toString,currentPerso)
      }
    } else if (keyEvent.getKeyCode == KeyEvent.VK_ENTER) {
      controller.resolveAll()
      if (controller.isFightDone) {
        view.panelHome.removeKeyListener(view.keyboardFightListener)
        view.panelHome.addKeyListener(view.keyboardListener)
      }
    }
  }

  def keyTyped(keyEvent: KeyEvent) {}

  def keyReleased(keyEvent: KeyEvent) {}

  def mouseExited(mouseEvent: MouseEvent) {}

  def mouseClicked(mouseEvent: MouseEvent) {}

  def mouseEntered(mouseEvent: MouseEvent) {}

  def mousePressed(mouseEvent: MouseEvent) {}

  def mouseReleased(mouseEvent: MouseEvent) {}


}
