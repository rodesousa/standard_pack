package standard.model.event

/**
 * * Created by rds on 15/05/15.
 */

abstract class EventAction {

  // c'est un truc de view !!!!!!
  // TODO
  def possiblesTouch: List[Int]

  def eventDone: Boolean

}
