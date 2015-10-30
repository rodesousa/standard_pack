package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
trait HaveEvent {

  //TODO val ici !
  //  var event : Event = null

  var current: EventAction = null
  var next: HaveEvent = null

}
