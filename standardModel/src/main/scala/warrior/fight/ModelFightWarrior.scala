package warrior.fight

import standard.model.fight.ModelFight
import warrior.fight.technique.action.ActionFight
import warrior.perso.job.CharacterFighterWarrior

/**
 * * Created by rds on 21/05/15.
 */

class ModelFightWarrior(_atacker: CharacterFighterWarrior, _defenser: CharacterFighterWarrior) extends ModelFight(_atacker, _defenser) {

  var actionAtacker: ActionFight = null

  override def atacker = _atacker

  override def defenser = _defenser

  def atackerTechniques = _atacker.listTechnique

}
