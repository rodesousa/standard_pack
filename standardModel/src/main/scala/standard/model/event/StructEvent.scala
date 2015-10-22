package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
class StructEvent {
  var haveEvent: HaveEvent = null

  def nextEvent() = {
    if (haveEvent.event.next != null) {
      haveEvent.event.current = haveEvent.event.next.current
      if (haveEvent.event.next.next != null)
        haveEvent.event.next = haveEvent.event.next.next
    }
    else
      haveEvent = null

    println(s"Il y a un ${haveEvent.event.current} qui arrive")
  }
}