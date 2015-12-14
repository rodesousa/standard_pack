package warrior.launcher

/**
 * * Created by rds on 16/05/15.
 */
object Test {

  def define(t: Event): Unit = {
    t match {
      case e: EventUn => println("un")
      case e: EventDeux => println("deux")
      case e: EventTrois => println("trois")
      case e: Event => println("zero")
    }
  }

  class Event()

  class EventUn() extends Event

  class EventDeux() extends Event

  //
  //  def main(args: Array[String]) {
  //
  //    define(new EventUn)
  //
  //
  //  }

  class EventTrois() extends Event

}
