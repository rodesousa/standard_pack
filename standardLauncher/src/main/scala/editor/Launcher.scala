package editor

import controller.editor.controller.ControllerEditor
import editor.model.ModelEditor
import editor.model.map.MapEditor
import editor.model.perso.PersoEditor
import editor.resources.Variables
import standard.model.item.weapon.SimpleSword
import view.editor.ViewEditor

object Launcher {
  def main(args: Array[String]) {
    val model = new ModelEditor(new MapEditor,new PersoEditor(Variables.PERSONNAGE_NAME) {
    var str = 10
    var defe = 10
    var agi = 10
    var arme = new SimpleSword
    var hpMax = 100
    var vit = 10
  } )
    val controller = new ControllerEditor(model)
    new ViewEditor(controller)

  }
}
