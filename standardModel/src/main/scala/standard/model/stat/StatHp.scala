package standard.model.stat

/**
 * * Created by rds on 11/05/15.
 */
trait StatHp {

  var hpCurrent = 0

  def vit: Int

  def hpMax: Int

  def die: Boolean = hpCurrent <= 0
}
