package standard.resources

import scala.collection.mutable.MutableList

trait Observer[T] {
  val list: MutableList[T] = new MutableList

  def receiveUpdate;
}

trait Subject[T] {
  private var observer: Observer[T] = null

  def addObserver(observer: Observer[T]) = this.observer = observer

  def addEleObserver(ele: T) = {
    observer.list.+=(ele); notifyObserver
  }

  def notifyObserver = observer.receiveUpdate
}

