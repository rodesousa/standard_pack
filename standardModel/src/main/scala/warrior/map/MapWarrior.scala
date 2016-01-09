package warrior.map

import standard.model.map.Map
import warrior.model.ModelWarrior

/**
 * *  Created by rds on 07/05/15.
 */
abstract class MapWarrior(_nomFichier: String) extends Map(_nomFichier) {
  def init(model: ModelWarrior)
}
