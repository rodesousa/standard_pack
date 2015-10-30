package view.swing.warrior.listener

import java.awt.event.KeyEvent

import standard.resources.Variables
import standard.resources.Variables._
import view.swing.standard.listener.Listener
import view.swing.warrior.ViewWarrior

/**
 * * Created by rds on 11/05/15.
 */
class ListenerWarrior(view: ViewWarrior) extends Listener(view) {
  val currentPerso = view.model.currentPerso

  override def keyPressed(e: KeyEvent) {
    if (view.model.stateGame != Variables.EVENT_FIGHT_DONE) {
      if (view.controller.lifeAction(e.getKeyCode)) {
        if (e.getKeyCode == KeyEvent.VK_RIGHT || e.getKeyCode == KeyEvent.VK_LEFT ||
          e.getKeyCode == KeyEvent.VK_UP || e.getKeyCode == KeyEvent.VK_DOWN) {
          view.controller.move(e.getKeyCode.toString, currentPerso)
        }
        else if (e.getKeyCode == KeyEvent.VK_ENTER) {
          view.controller.resolveAll()
          if (view.controller.model.stateGame == EVENT_BEGIN_FIGHT) {
            view.initFight()
            changeGametoFight()
          }
        }

        if (view.controller.model.stateGame == EVENT_FIGHT)
          view.panelFight.updateUI()
        else
          view.panelGame.updateUI()

        if (Variables.DEBUG)
          println(s"Etat du jeu: ${view.controller.model.stateGame}")
      }
    }
    else {
      // FIN D'UN COMBAT
      this.changeFightToGame()
      view.controller.nextEvent()
      view.panelGame.updateUI()
    }
  }
}

