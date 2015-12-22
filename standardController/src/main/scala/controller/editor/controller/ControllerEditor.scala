package controller.editor.controller

import controller.standard.Controller
import controller.standard.fight.ControllerFight
import controller.standard.resolver.Resolver
import editor.model.ModelEditor
import standard.resources.Variables


class ControllerEditor(_model: ModelEditor) extends Controller(_model) {

  val controllerFight = new ControllerFight {}
  val resolver = new Resolver {}

  def model = _model

  def printXY() = {
    println(s"${model.currentPerso.x} ${model.currentPerso.y}")
  }

  def writeZoneWalking() = {
    if (!model.mutableZoneWalking.contains((model.currentPerso.x, model.currentPerso.y)))
      model.mutableZoneWalking = (model.currentPerso.x, model.currentPerso.y) :: model.mutableZoneWalking
  }

  def setZoneWalking() {
    model.mutableZoneWalking.foreach(a => print(s"${a._1} ${a._1};"))
  }

  def removeZoneWalking(direction: String) {
    def x = model.currentPerso.x
    def y = model.currentPerso.y
    def pas = model.currentPerso.pas
    direction match {
      case Variables.DIRECTION_LEFT =>
        if (model.mutableZoneWalking.contains((x + (pas * -1), y))) {
          model.mutableZoneWalking = model.mutableZoneWalking.filter(_ !=(x + (pas * -1), y))
        }
      case Variables.DIRECTION_RIGHT =>
        if (model.mutableZoneWalking.contains((x + (pas * 1), y))) {
          model.mutableZoneWalking = model.mutableZoneWalking.filter(_ !=(x + (pas * 1), y))
        }
      case Variables.DIRECTION_UP =>
        if (model.mutableZoneWalking.contains((x, y + (pas * -1)))) {
          model.mutableZoneWalking = model.mutableZoneWalking.filter(_ !=(x, y + (pas * -1)))
        }
      case Variables.DIRECTION_DOWN =>
        if (model.mutableZoneWalking.contains((x, y + (pas * 1)))) {
          model.mutableZoneWalking = model.mutableZoneWalking.filter(_ !=(x, y + (pas * 1)))
        }
    }
  }

}