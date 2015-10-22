package editor.view.listener

import java.awt.event.KeyEvent

import editor.view.ViewEditor
import standard.view.swing.listener.Listener

/**
 * Created by rodesousa on 21/10/15.
 */
class ListenerEditor(view: ViewEditor) extends Listener(view) {

  override def keyPressed(e: KeyEvent) {
    if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
      e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
      view.model.currentPerso canDo(view.model, e.getKeyCode.toString)
    }
    else if (e.getKeyCode == KeyEvent.VK_C) {
      view.model.setListToZoneWalking
    }
    else if (e.getKeyCode == KeyEvent.VK_X) {
      view.model.writeZoneWalkingMap
    }
    else if (e.getKeyCode == KeyEvent.VK_W) {
    }
    view.panelGame.updateUI()
  }

}
