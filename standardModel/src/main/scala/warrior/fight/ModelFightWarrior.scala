package warrior.fight

import standard.model.fight.ModelFight
import warrior.fight.technique.action.ActionFight
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 21/05/15.
 */

class ModelFightWarrior(_atacker: CharacterFighter, _defenser: CharacterFighter) extends ModelFight(_atacker, _defenser) {

  override def atacker = _atacker

  override def defenser = _defenser

  def atackerTechniques = _atacker.listTechnique

  var actionAtacker: ActionFight = null

}
