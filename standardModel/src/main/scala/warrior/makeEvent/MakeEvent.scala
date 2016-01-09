package warrior.makeEvent

import standard.model.event.action.{EventDialogue, EventDone}
import standard.model.event.{EventAction, Events, HaveEvent}
import standard.model.map.cellule.Cellule
import warrior.model.ModelWarrior

/**
 * Created by rodesousa on 03/01/16.
 */
object MakeEvent {

  def eventDone(fn: () => Int): EventDone = new EventDone {
    def nextStep = fn
  }

  def eventDone0(): EventDone = new EventDone {
    def nextStep = () => 0
  }

  def makeHaveEvent1(listActions: EventAction): HaveEvent = {
    new HaveEvent {
      val listEvents = List(List(listActions))
      var currentEvents = listEvents.head
    }
  }

  def makeHaveEvent2(events: List[EventAction]): HaveEvent = {
    new HaveEvent {
      val listEvents = List(events)
      var currentEvents = listEvents.head
    }
  }

  def makeHaveEvent3(events: List[List[EventAction]]): HaveEvent = {
    new HaveEvent {
      val listEvents = events
      var currentEvents = listEvents.head
    }
  }

  def makeDialogue(_subject: String, _text: String): EventDialogue = new EventDialogue {
    var subject = _subject
    var text = _text

    def eventDone = true
  }

  //  def addEventNext(current: HaveEvent, next: HaveEvent): Unit = {
  //    current.next = Some(next)
  //  }

  def initEvent(_events: HaveEvent, perso: Events, cellule: Cellule, model: ModelWarrior): Unit = {
    pasteEvent(perso, new Events {
      events = Some(_events)
    })
    cellule.event = perso.events
    model.currentMap.cellules = cellule :: model.currentMap.cellules
  }

  def pasteEvent(from: Events, to: Events): Unit = {
    from.events = to.events
  }

  // quand on finit la suite d'event et qu'on recommence a resoudre l'event depuis le debut
  //  def resetEvent(haveEvent: HaveEvent, event: HaveEvent): Unit = {
  //    val deplacement = newDeplacement
  //    addEventNext(deplacement, event)
  //    addEventNext(haveEvent, deplacement)
  //  }

}
