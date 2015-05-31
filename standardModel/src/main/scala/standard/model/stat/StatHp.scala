package standard.model.stat

/**
 * * Created by rds on 11/05/15.
 */
trait StatHp {
  var vit = 1
  var hpMax = 1
  var hpCurrent = hpMax

  def die: Boolean = hpCurrent <= 0
}
