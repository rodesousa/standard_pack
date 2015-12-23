package warrior.model

import standard.model.model.Model
import warrior.fight.ModelFightWarrior
import warrior.map.MapWarrior
import warrior.perso.CharacterFighter

/**
 * Created by rodesousa on 20/10/15.
 */
class ModelWarrior(var currentMap: MapWarrior, var currentPerso: CharacterFighter) extends Model(currentMap, currentPerso) {
  var modelFight: ModelFightWarrior = null

  def etatMaps = null

  def etatCompagnons = null
}
