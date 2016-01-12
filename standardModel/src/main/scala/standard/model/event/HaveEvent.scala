package standard.model.event

/**
 * * Created by rds on 20/05/15.
 */
abstract class HaveEvent {

  // indice de event dans currentEvents
  var eventIndex = 0

  def listEvents: List[List[EventAction]]

  // la suite d'events en cours dans listEvents
  def currentEvents: List[EventAction]
}
