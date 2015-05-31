package standard.model.job

import standard.model.item.Item
import standard.model.item.money.Price
import standard.model.perso.Personnage

/**
 * * Created by rds on 26/05/15.
 */
class SellerJob(_seller : Personnage, _storage : List[Item with Price]){
  def seller = _seller
  def storage = _storage
}
