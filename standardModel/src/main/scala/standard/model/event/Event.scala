package standard.model.event

/**
 * * Created by rds on 15/05/15.
 */
trait Event {
  var current : EventAction
  var next : Event
}

