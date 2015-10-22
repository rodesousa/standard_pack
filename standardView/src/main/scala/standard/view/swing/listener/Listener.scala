package standard.view.swing.listener

import java.awt.event.{KeyListener, MouseListener}

import standard.view.swing.View

/**
 * Created by rodesousa on 21/10/15.
 */
class Listener(view: View) extends KeyListener with MouseListener {

  import java.awt.event.{KeyEvent, MouseEvent}

  def keyPressed(e: KeyEvent) {
    if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
      e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
      view.model.currentPerso canDo(view.model, e.getKeyCode.toString)
    }
    else if (e.getKeyCode == KeyEvent.VK_W) {
    }
    view.panelGame.updateUI()
  }

  def keyReleased(x$1: KeyEvent): Unit = {}

  def keyTyped(x$1: KeyEvent): Unit = {}

  def mouseClicked(x$1: MouseEvent) {}

  def mouseEntered(x$1: MouseEvent) {}

  def mouseExited(x$1: MouseEvent) {}

  def mousePressed(x$1: MouseEvent) {}

  def mouseReleased(x$1: MouseEvent) {}

  def changeGametoFight() {
    view.panelHome.remove(view.panelGame)
    view.panelHome.removeKeyListener(view.keyboardListener)
    view.panelFight.setFocusable(true)
    view.panelHome.add(view.panelFight)
    view.panelHome.addKeyListener(view.keyboardFightListener)
    view.controller.fightBegin()
  }

  def changeFightToGame() {
    view.panelHome.remove(view.panelFight)
    view.panelHome.removeKeyListener(view.keyboardFightListener)
    view.panelHome.addKeyListener(view.keyboardListener)
    view.panelFight.setFocusable(true)
    view.panelHome.add(view.panelGame)
    view.controller.fightDone()
  }
}
