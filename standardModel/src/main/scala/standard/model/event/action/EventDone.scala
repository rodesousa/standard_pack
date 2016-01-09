package standard.model.event.action

import standard.model.event.EventAction
import standard.resources.Variables

/**
 * Created by rodesousa on 08/01/16.
 */
trait EventDone extends EventAction {

  override def toString: String = "Event Done"

  def possiblesTouch: List[Int] = Variables.listFight ::: Variables.listDeplacement ::: Variables.listDialogue

  // en valeur de retour l'indice d'une liste event dans un type Events
  def nextStep: () => Int

  def eventDone = true
}
