package standard.model.fight

import standard.model.perso.Personnage

/**
 * * Created by rds on 21/05/15.
 */
abstract class ModelFight {
  def atacker: Personnage with Fighter
  def defenser: Personnage with Fighter
}
