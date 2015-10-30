package warrior.fight

import standard.resources.Variables._
import warrior.fight.technique.action.ActionFight
import warrior.model.ModelWarrior
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 11/05/15.
 */
object ResolveFight {

  def fight(atacker: CharacterFighter, defenser: CharacterFighter,
            model: ModelWarrior, action: ActionFight) {
    val maxRange = 0

    if (DEBUG) {
      println("FIGHT !")
      println("Range des persos: " + maxRange)
      println("Atack touche ? " + (atacker.listTechnique.head.listAtk.head.range._1 >= maxRange))
      println("Def touche ? " + (defenser.listTechnique.head.listAtk.head.range._1 >= maxRange))
    }

    if (atacker.listTechnique.head.listAtk.head.range._1 >= maxRange) {
      defenser.hpCurrent -= atacker.atack(action)

      if (DEBUG)
        println(s" L'attaque de l'atacker: ${atacker.atack(action)}")

    }

    if (!atacker.die) {
      if (defenser.listTechnique.head.listAtk.head.range._1 >= maxRange) {

        //TODO resoudre l'attaque du défenseur
        atacker.hpCurrent -= defenser.atack(defenser.listTechnique.head.listAtk.head)

        if (DEBUG)
          println(s" L'attaque du defenser: ${defenser.atack(action)}")

      }
    }

  }
}
