package view.standard.listener

import java.awt.event.{KeyListener, MouseListener}

import view.standard.View

/**
 * Created by rodesousa on 21/10/15.
 */
class Listener(view: View) extends KeyListener with MouseListener {

  import java.awt.event.{KeyEvent, MouseEvent}

  def keyPressed(e: KeyEvent) {
    if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
      e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
      view.model.currentPerso canDo(view.model, e.getKeyCode.toString, view.model.currentPerso.info.nbrPas)
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

  //TODO CHANGER DENDROIT
  def changeGametoFight() {
    view.panelHome.removeAll()
    view.panelHome.removeKeyListener(view.keyboardListener)
    view.panelHome.addKeyListener(view.keyboardFightListener)
    view.panelHome.add(view.panelFight)
    view.panelFight.setVisible(true)
    view.panelGame.setVisible(true)
    view.controller.fightBegin()
  }

  //TODO CHANGER DENDROIT
  def changeFightToGame() {
    view.panelHome.removeAll()
    view.panelHome.add(view.panelGame)
    view.panelGame.setFocusable(true)
    view.panelHome.setVisible(true)
    view.controller.eventDone()
  }
}
