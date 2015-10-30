package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
class StructEvent {
  var events: HaveEvent = null

  def nextEvent() = {
    if (events.next != null) {
      events.current = events.next.current
      if (events.next.next != null)
        events.next = events.next.next
    }
    else
      events = null
  }

}