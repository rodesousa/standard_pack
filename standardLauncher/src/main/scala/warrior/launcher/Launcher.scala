package warrior.launcher

import controller.warrior.ControllerWarrior
import view.swing.warrior.ViewWarrior
import warrior.example.Persos
import warrior.model.ModelWarrior

/**
*  Created by rodesousa on 22/10/15.
*/
object Launcher {
  def main(args: Array[String]) {
    val model = new ModelWarrior
    Persos.PnjTOEvent(model)
    val controller = new ControllerWarrior(model)
    val view = new ViewWarrior(controller)
  }
}