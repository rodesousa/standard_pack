package view.editor.listener

import java.awt.event.KeyEvent

import view.editor.ViewEditor
import view.standard.listener.Listener

/**
 * Created by rodesousa on 21/10/15.
 */
class ListenerEditor(view: ViewEditor) extends Listener(view) {

  override def keyPressed(e: KeyEvent) {
    e.getKeyCode match {
      case KeyEvent.VK_RIGHT | KeyEvent.VK_LEFT | KeyEvent.VK_UP | KeyEvent.VK_DOWN => view.model.currentPerso
        .canDo(view.model, e.getKeyCode.toString)
      case KeyEvent.VK_W => view.controller.writeZoneWalking()
      case KeyEvent.VK_S => view.controller.setZoneWalking()
      case KeyEvent.VK_P => view.controller.printXY()
      case KeyEvent.VK_R => view.controller.removeZoneWalking(view.panelGame.viewPerso.currentDirection)
      case _ => ()
    }
    view.panelGame.updateUI()
  }

}
