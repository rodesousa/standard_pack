package warrior.map.map1

import standard.model.event.action.EventDialogue
import standard.model.job.SellerJob
import standard.model.map.cellule.Cellule
import standard.model.perso.job.{Pnj, PnjFighter}
import standard.resources.Variables
import warrior.example.Persos
import warrior.fight.technique.impl.{AxeMercenary, SpearMercenary, SwordMercenary}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.axe.AxeStandard
import warrior.item.weapon.spear.SpearStandard
import warrior.item.weapon.sword.SwordStandard
import warrior.makeEvent.MakeEvent
import warrior.map.MapWarrior
import warrior.model.ModelWarrior

/**
 * * Created by rds on 22/05/15.
 */
object Map1 extends MapWarrior(Variables.MAP_NAME) {
  //TODO Retravailler la class


  def newDialogue(subject: String, text: String): EventDialogue = {
    MakeEvent.makeDialogue(subject, text)
  }

  def init(model: ModelWarrior) {
    // // //
    // SANS NOM
    // // //
    val eventDialogueSansNom = MakeEvent.makeHaveEvent2(List(newDialogue("sansNom", "Passe ton chemin"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(eventDialogueSansNom, Persos.noName, new Cellule(0, 75), model)

    // // //
    // characterCamp1
    // // //
    val haveEventCamp1 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp1", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp1, characterCamp1, new Cellule(165, 555), model)

    // // //
    // characterCamp2
    // // //
    val haveEventCamp2 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp2", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp2, characterCamp2, new Cellule(90, 720), model)

    // // //
    // characterCamp3
    // // //
    val haveEventCamp3 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp3", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp3, characterCamp3, new Cellule(45, 720), model)

    // // //
    // characterCamp4
    // // //

    val haveEventCamp4 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp4", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp4, characterCamp4, new Cellule(645, 555), model)

    // // //
    // characterCamp6
    // // //
    val haveEventCamp6 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp6", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp6, characterMerchant, new Cellule(810, 555), model)

    // // //
    // characterCamp7
    // // //
    val haveEventCamp7 = MakeEvent.makeHaveEvent2(List(newDialogue("merchant", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp7, characterMerchant, new Cellule(885, 360), model)

    // // //
    // characterCamp8
    // // //
    val haveEventCamp8 = MakeEvent.makeHaveEvent2(List(newDialogue("romulus", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp8, Persos.romulus, new Cellule(885, 180), model)

    // // //
    // characterCamp9
    // // //
    val haveEventCamp9 = MakeEvent.makeHaveEvent2(List(newDialogue("remus", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp9, Persos.remus, new Cellule(915, 180), model)

    // // //
    // characterCamp10
    // // //
    val haveEventCamp10 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp8", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp10, characterCamp4, new Cellule(600, 180), model)

    // // //
    // characterCamp11
    // // //
    val haveEventCamp11 = MakeEvent.makeHaveEvent2(List(newDialogue("Camp9", "bla bla"), MakeEvent.eventDone0()))
    MakeEvent.initEvent(haveEventCamp11, lambda1, new Cellule(360, 45), model)
  }


  // // //
  // Perso
  // // //

  // CAMP1
  val characterCamp1 = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new AxeStandard
    val axeMercenary = new AxeMercenary {
      val listAtk = base :: Nil
    }
    var listTechnique = axeMercenary :: Nil
  }

  //CAMP2
  val characterCamp2 = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = base :: Nil
    }
    var listTechnique = spearMercenary :: Nil
  }

  val characterCamp3 = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = base :: Nil
    }
    var listTechnique = swordMercenary :: Nil
  }

  val characterCamp4 = new Pnj(Variables.NOTIMPLE) {
  }

  val characterCamp5 = new Pnj(Variables.NOTIMPLE) {
  }

  val characterFighter1 = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = base :: Nil
    }
    var listTechnique = spearMercenary :: Nil
  }

  val characterFighter2 = new PnjFighter(Variables.NOTIMPLE) {
    var str = 3
    var vit = 50
    var hpMax = 10
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = base :: Nil
    }
    var listTechnique = swordMercenary :: Nil
  }

  val characterMerchant = new Pnj(Variables.NOTIMPLE) {
  }

  val marchandDeplca = new SellerJob(characterMerchant, Nil) {
  }

  val lambda1 = new Pnj(Variables.NOTIMPLE) {
  }

  val lambda2 = new Pnj(Variables.NOTIMPLE) {
  }

  val lambda3 = new Pnj(Variables.NOTIMPLE) {
  }


}
