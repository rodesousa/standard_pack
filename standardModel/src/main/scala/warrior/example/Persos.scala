package warrior.example

import standard.model.event.HaveEvent
import standard.model.event.action.{EventDeplacement, EventDialogue, EventFight}
import standard.model.map.cellule.Cellule
import standard.model.model.Model
import standard.resources.Variables._
import warrior.fight.technique.impl.{HittenMitsurugiRyu, SwordBase}
import warrior.item.weapon.sword.SwordStandard
import warrior.model.ModelWarrior
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 21/05/15.
 */
object Persos {

  def createPersos = {
    val p2 = new CharacterFighter(PERSONNAGE_NAME) {
      info.name = "Pooman"
      var str = 5
      var defe = 5
      var agi = 5
      var hpMax = 50
      var vit = 5
      hpCurrent = hpMax

      val base: SwordBase = new SwordBase {
        val listAtk = atack :: Nil
      }
      var listTechnique = base :: Nil
      var arme = new SwordStandard
    }
    createPersoPri :: p2 :: Nil
  }

  def createPersoPri = {

    new CharacterFighter(PERSONNAGE_NAME) {
      info.name = "Kenshin"
      var str = 10
      var defe = 10
      var agi = 10
      var vit = 10
      var hpMax = 50
      hpCurrent = hpMax

      val ryu = new HittenMitsurugiRyu {
        val listAtk = dragonDivin :: Nil
      }

      val base: SwordBase = new SwordBase {
        val listAtk = atack :: Nil
      }

      var listTechnique = ryu :: base :: Nil

      var arme = new SwordStandard
    }
  }

  def PnjTOEvent(model: ModelWarrior) {
    val pnj = createPNJ

    val cellule = new Cellule(0, 0) {
      event = pnj
    }

    model.currentMap.cellules = cellule :: model.currentMap.cellules
  }

  def createPNJ: CharacterFighter with HaveEvent = {
    new CharacterFighter(PERSONNAGE_NAME) with HaveEvent {
      info.name = "Pooman"
      var str = 5
      var defe = 5
      var agi = 5
      var hpMax = 50
      var vit = 5
      hpCurrent = hpMax

      val base: SwordBase = new SwordBase {
        val listAtk = atack :: Nil
      }

      var listTechnique = base :: Nil
      var arme = new SwordStandard

      val deplacement = new EventDeplacement {
        val list = listDeplacement

        def eventDone(model: Model): Boolean = true
      }

      val dialogueFin = new EventDialogue {
        var subject = "Bastien la fiotte"
        var text = "Bo GOSSE"
        val list = listDialogue

        def eventDone(model: Model): Boolean = {
          println("FCO")
          true
        }
      }

      val haveEvent = new HaveEvent {
        current = dialogueFin
        next = new HaveEvent {
          current = deplacement
          next = null
        }
      }

      haveEvent.next.next = haveEvent

      current = new EventDialogue {
        val subject = "Bastien la fiotte"
        val text = "Halte la PD ! Combattons comme de jeune pucelle !"
        val list = listDialogue

        def eventDone(model: Model): Boolean = {
          true
        }

      }
      next = new HaveEvent {
        current = new EventFight {
          val list = listFight

          def eventDone(model: Model): Boolean = {
            model.modelFight.atacker.die || model.modelFight.defenser.die
          }
        }
        next = haveEvent
      }
    }
  }
}