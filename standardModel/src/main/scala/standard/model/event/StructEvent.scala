package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
class StructEvent {
  var events: Option[HaveEvent] = None

  // si il existe un next event alors il devient current
  // si next de next existe alors il devient current de next
  def nextEvent() = {
    if (events.get.next.isDefined) {
      events.get.current = events.get.next.get.current
      if (events.get.next.get.next.isDefined)
        events.get.next = events.get.next.get.next
    }
  }

}