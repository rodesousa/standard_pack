package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
abstract class HaveEvent {

  def listEvents: List[List[EventAction]]

  // indice de event dans currentEvents
  var eventIndex = 0

  // la suite d'events en cours dans listEvents
  def currentEvents: List[EventAction]
}
