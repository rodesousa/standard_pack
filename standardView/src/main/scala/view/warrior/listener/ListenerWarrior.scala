package view.warrior.listener

import java.awt.event.KeyEvent

import standard.resources.Variables
import standard.resources.Variables._
import view.standard.listener.Listener
import view.warrior.ViewWarrior

/**
 * * Created by rds on 11/05/15.
 */
class ListenerWarrior(view: ViewWarrior) extends Listener(view) {
  val currentPerso = view.model.currentPerso

  override def keyPressed(e: KeyEvent) {
    if (view.model.stateGame != Variables.EVENT_FIGHT_DONE) {
      if (view.controller.lifeAction(e.getKeyCode)) {
        // Soit on se deplace soit on essaye un event
        e.getKeyCode match {
          case KeyEvent.VK_RIGHT | KeyEvent.VK_LEFT | KeyEvent.VK_UP | KeyEvent.VK_DOWN =>
            view.controller.move(e.getKeyCode.toString, currentPerso)
          case KeyEvent.VK_ENTER =>
            println(s"avant resolve - ${view.model.stateGame}")
            view.controller.resolveAll()
            println(s"apres resolve - ${view.model.stateGame}")
            println("-----------------------------------------")
            if (view.controller.model.stateGame == EVENT_BEGIN_FIGHT) {
              view.initFight()
              changeGametoFight()
            }
          case _ => ()
        }
      }
      // passage au listenerFightWarrior
      if (view.controller.model.stateGame == EVENT_FIGHT)
        view.panelFight.updateUI()
      else
        view.panelGame.updateUI()

    }
    else {
      // FIN D'UN COMBAT
      this.changeFightToGame()
      view.controller.nextEvent()
      view.panelGame.updateUI()
    }
  }
}

