package warrior.makeEvent

import standard.model.event.HaveEvent
import standard.model.event.action.EventDialogue
import standard.model.model.Model

/**
 * Created by rodesousa on 03/01/16.
 */
object MakeEvent {


  def makeDialogue(_subject: String, _text: String): EventDialogue = {
    new EventDialogue {
      var subject = _subject
      var text = _text

      def eventDone(model: Model) = true
    }
  }

  def makeNextEvent(eventNext: HaveEvent, eventCurrent: HaveEvent): Unit = {
    eventCurrent.next = Some(eventNext)
  }

}
