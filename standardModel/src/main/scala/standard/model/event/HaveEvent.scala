package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
trait HaveEvent {

  var current: Option[EventAction] = None
  var next: Option[HaveEvent] = None

}
