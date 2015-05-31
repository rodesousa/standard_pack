package editor.view

import java.awt.event.{KeyListener, MouseListener}
import javax.swing.JFrame
import editor.model.ModelEditor
import editor.view.panel.PanelEditor

class ViewEditor(model: ModelEditor) extends JFrame {

  var panelPrincipal = new PanelEditor(model)
  val clavierListenner = new ClavierListenner(this, this.model)

  //conf panelPrincipal
  panelPrincipal.addKeyListener(clavierListenner)
  panelPrincipal.addMouseListener(clavierListenner)
  panelPrincipal.setFocusable(true)

  //Option de la fenetre
  this.setTitle("TestJeuxEditor")
  this.setSize(800, 600)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setContentPane(panelPrincipal)
  this.setVisible(true)
}

class ClavierListenner(view: ViewEditor, model: ModelEditor) extends KeyListener with MouseListener {

  import java.awt.event.{KeyEvent, MouseEvent}

  def keyPressed(e: KeyEvent) {
    if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
      e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
      model.currentPerso canDo(model, e.getKeyCode.toString)
    }
    else if (e.getKeyCode == KeyEvent.VK_C) {
      model.setListToZoneWalking
    }
    else if (e.getKeyCode == KeyEvent.VK_X) {
      model.writeZoneWalkingMap
    }
    else if (e.getKeyCode == KeyEvent.VK_W) {
    }
    view.panelPrincipal.updateUI()
  }

  def keyReleased(x$1: KeyEvent): Unit = {}

  def keyTyped(x$1: KeyEvent): Unit = {}

  def mouseClicked(x$1: MouseEvent) {}

  def mouseEntered(x$1: MouseEvent) {}

  def mouseExited(x$1: MouseEvent) {}

  def mousePressed(x$1: MouseEvent) {}

  def mouseReleased(x$1: MouseEvent) {}
}