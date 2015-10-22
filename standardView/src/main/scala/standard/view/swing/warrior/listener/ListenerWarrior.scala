package standard.view.swing.warrior.listener

import java.awt.event.KeyEvent

import standard.resources.Variables._
import standard.view.swing.listener.Listener
import standard.view.swing.panel.PanelFight
import standard.view.swing.warrior.ViewWarrior

/**
 * * Created by rds on 11/05/15.
 */
class ListenerWarrior(view: ViewWarrior) extends Listener(view) {
  val currentPerso = view.model.currentPerso

  override def keyPressed(e: KeyEvent) {
    if (view.controller.lifeAction(e.getKeyCode)) {
      if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
        e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
        view.controller.move(e.getKeyCode.toString, currentPerso)
           }
      else if (e.getKeyCode == KeyEvent.VK_ENTER) {
        if (view.controller.isFightDone) {
          changeFightToGame()
        }
        else {
          view.controller.resolveAll()
          if (view.controller.model.stateGame == EVENT_BEGIN_FIGHT) {
            println("La Bataille commence")
            view.initFight()
            changeGametoFight()
          }
        }
      }

      if (view.controller.model.stateGame == EVENT_FIGHT)
        view.panelFight.updateUI()
      else
        view.panelGame.updateUI()
      println(s"Etat du jeu: ${view.controller.model.stateGame}")
    }
  }

}

