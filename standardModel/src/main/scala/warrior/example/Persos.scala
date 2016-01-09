package warrior.example

import standard.model.perso.job.{Pnj, PnjFighter}
import standard.resources.Variables
import standard.resources.Variables._
import warrior.fight.technique.Dan
import warrior.fight.technique.impl._
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.axe.AxeStandard
import warrior.item.weapon.rod.RodStandard
import warrior.item.weapon.sword.SwordStandard
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 21/05/15.
 */
object Persos {

  val noName = new PnjFighter(Variables.NOTIMPLE) {
    // STAT
    var str = 50
    var vit = 50
    var defe = 50
    var agi = 1
    var hpMax = 10
    // WEAPON
    var arme: WarriorWeapon = new AxeStandard
    // SKILL
    val pelerin = new FauconPelerin {
      val listAtk = pic :: rafale :: Nil
    }
    val death = new DeathStyle {
      val listAtk = lethale :: Nil
      val maxDan = Dan.un
    }
    var listTechnique = pelerin :: death :: Nil
  }


  val technicien = new Pnj(Variables.NOTIMPLE) {
  }

  val compteur = new Pnj(Variables.NOTIMPLE) {
  }

  val romulus = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = base :: Nil
    }
    var listTechnique = spearMercenary :: Nil
  }

  val remus = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = base :: Nil
    }
    var listTechnique = spearMercenary :: Nil
  }

  val inscripteur = new Pnj(Variables.NOTIMPLE) {
  }


  //  def createPersos = {
  //    val p2 = new CharacterFighter(PERSONNAGE_NAME) {
  //      info.name = "Pooman"
  //      var str = 5
  //      var defe = 5
  //      var agi = 5
  //      var hpMax = 50
  //      var vit = 5
  //      hpCurrent = hpMax
  //
  //      val base: SwordBase = new SwordBase {
  //        val listAtk = atack :: Nil
  //      }
  //      var listTechnique = base :: Nil
  //      var arme = new SwordStandard
  //    }
  //    createPersoPri :: p2 :: Nil
  //  }
  //
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

  //
  //  def PnjTOEvent(model: ModelWarrior) {
  //    val pnj = createPNJ
  //
  //    val cellule = new Cellule(0, 75) {
  //      event = pnj
  //    }
  //
  //    model.currentMap.cellules = cellule :: model.currentMap.cellules
  //  }
  //
  //  def createPNJ: CharacterFighter with HaveEvent = {
  //    new CharacterFighter(PERSONNAGE_NAME) with HaveEvent {
  //      info.name = "Pooman"
  //      var str = 5
  //      var defe = 5
  //      var agi = 5
  //      var hpMax = 50
  //      var vit = 5
  //      hpCurrent = hpMax
  //
  //      val base: SwordBase = new SwordBase {
  //        val listAtk = atack :: Nil
  //      }
  //
  //      var listTechnique = base :: Nil
  //      var arme = new SwordStandard
  //
  //      val deplacement = new EventDeplacement {
  //        val list = listDeplacement
  //
  //        def eventDone(model: Model): Boolean = true
  //      }
  //
  //      val dialogueFin = new EventDialogue {
  //        var subject = "Bastien la fiotte"
  //        var text = "Bo GOSSE"
  ////        val list = listDialogue
  //
  //        def eventDone(model: Model): Boolean = {
  //          true
  //        }
  //      }
  //
  //      val haveEvent = new HaveEvent {
  //        current = dialogueFin
  //        next = new HaveEvent {
  //          current = deplacement
  //          next = null
  //        }
  //      }
  //
  //      haveEvent.next.next = haveEvent
  //
  //      current = new EventDialogue {
  //        val subject = "Bastien la fiotte"
  //        val text = "Halte la PD ! Combattons comme de jeune pucelle !"
  ////        val list = listDialogue
  //
  //        def eventDone(model: Model): Boolean = {
  //          true
  //        }
  //
  //      }
  //      next = new HaveEvent {
  //        current = new EventFight {
  //          val list = listFight
  //
  //          def eventDone(model: Model): Boolean = {
  //            model.modelFight.atacker.die || model.modelFight.defenser.die
  //          }
  //        }
  //        next = haveEvent
  //      }
  //    }
  //  }
}