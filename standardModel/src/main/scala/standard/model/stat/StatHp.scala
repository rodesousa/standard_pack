package standard.model.stat

/**
 * * Created by rds on 11/05/15.
 */
trait StatHp {

  def vit: Int

  def hpMax: Int

  var hpCurrent = 0

  def die: Boolean = hpCurrent <= 0
}
