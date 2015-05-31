package standard.model.map.cellule

import standard.model.event.HaveEvent

class Cellule(_x : Int,_y : Int){
  //position
  val x = _x
  val y = _y
  var event : HaveEvent = null
}
