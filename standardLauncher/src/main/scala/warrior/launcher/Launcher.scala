package warrior.launcher

import controller.warrior.ControllerWarrior
import standard.resources.Variables
import view.warrior.ViewWarrior
import warrior.example.Persos
import warrior.map.MapWarrior
import warrior.model.ModelWarrior

/**
 * Created by rodesousa on 22/10/15.
 */
object Launcher {
  def main(args: Array[String]) {
    // init model
    val model = new ModelWarrior(new MapWarrior(Variables.MAP_NAME), Persos.createPersoPri)

    Persos.PnjTOEvent(model)
    val controller = new ControllerWarrior(model)
    new ViewWarrior(controller)
  }
}