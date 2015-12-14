package view.warrior.fight.zone

import standard.resources.Variables

/**
 * Created by rodesousa on 23/10/15.
 */

abstract class Area[T](listElement: List[T]) {
  var mustPrint = false
  var positionElementCurrent = 0
  var elementCurrent: Option[T] = Some(listElement.head)
  var elementNext: Option[T] = determineElementNext(1)

  def x: Int

  def y: Int

  def move(direction: String) {
    direction match {
      case Variables.DIRECTION_UP => this.previous()
      case Variables.DIRECTION_DOWN => this.next()
    }
  }

  def next() {
    if (positionElementCurrent < listElement.size - 1)
      positionElementCurrent += 1
    else
      positionElementCurrent = 0
    elementCurrent = Some(listElement(positionElementCurrent))
    elementNext = this.determineElementNext(positionElementCurrent + 1)
  }

  def previous(): Unit = {
    if (positionElementCurrent == 0)
      positionElementCurrent = listElement.size - 1
    else
      positionElementCurrent -= 1
    elementCurrent = Some(listElement(positionElementCurrent))
    elementNext = this.determineElementNext(positionElementCurrent + 1)
  }

  def determineElementNext(i: Int): Option[T] = {
    if (listElement.isDefinedAt(i)) Some(listElement(i))
    else if (i - 1 != 0)
      Some(listElement.head)
    else None
  }
}
