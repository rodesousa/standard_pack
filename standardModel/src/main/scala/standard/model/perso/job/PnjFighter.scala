package standard.model.perso.job

import standard.model.event.Events
import warrior.perso.CharacterFighter

/**
 * Created by rodesousa on 08/01/16.
 */
abstract class PnjFighter(_name: String) extends CharacterFighter(_name) with Events{
}
