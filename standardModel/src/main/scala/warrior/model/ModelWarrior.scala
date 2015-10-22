package warrior.model

import standard.model.model.Model
import standard.resources.Variables
import warrior.example.Persos
import warrior.fight.ModelFightWarrior
import warrior.map.MapWarrior

/**
 * Created by rodesousa on 20/10/15.
 */
class ModelWarrior extends Model {
  var currentMap = new MapWarrior(Variables.MAP_NAME)
  var currentPerso = Persos.createPersoPri
  var modelFight : ModelFightWarrior = null

  def etatMaps = null

  def etatCompagnons = null
}
