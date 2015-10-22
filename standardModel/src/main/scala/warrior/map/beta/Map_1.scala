package warrior.map.beta

import standard.model.event.HaveEvent
import standard.model.job.SellerJob
import standard.model.perso.Personnage
import warrior.fight.technique.Dan
import warrior.fight.technique.impl.{AxeMercenary, DeathStyle, FauconPelerin, SpearMercenary, _}
import warrior.item.weapon.WarriorWeapon
import warrior.item.weapon.axe.AxeStandard
import warrior.item.weapon.rod.RodStandard
import warrior.item.weapon.spear.SpearStandard
import warrior.item.weapon.sword.SwordStandard
import warrior.map.MapWarrior
import warrior.perso.CharacterFighter

/**
 * * Created by rds on 22/05/15.
 */
class Map_1 extends MapWarrior("Map_1_Beta") {
  //TODO Retravailler la class

  // SANS NOM
  val sansNom = new CharacterFighter("chemin") with HaveEvent {
    //TODO refaire les stats
    var str = 50
    var defe = 50
    var agi = 1
    var arme: WarriorWeapon = new AxeStandard
    val pelerin = new FauconPelerin {
      val listAtk = (true, pic) ::(true, rafale) :: Nil
    }
    val death = new DeathStyle {
      val listAtk = (true, lethale) :: Nil
      val maxDan = Dan.un
    }
    var techniquesCombat = pelerin :: death :: Nil
  }

  // CAMP1
  val characterCamp1 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new AxeStandard
    val axeMercenary = new AxeMercenary {
      val listAtk = (true, base ):: Nil
    }
    var techniquesCombat = axeMercenary :: Nil
  }

  //CAMP2
  val characterCamp2 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val characterCamp3 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = swordMercenary :: Nil
  }

  val characterCamp4 = new Personnage("chemin") {
  }

  val characterCamp5 = new Personnage("chemin") {
  }

  val technicien = new Personnage("chemin") {
  }

  val characterFighter1 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SpearStandard
    val spearMercenary = new SpearMercenary {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val characterFighter2 = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme: WarriorWeapon = new SwordStandard
    val swordMercenary = new SwordMercenary {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = swordMercenary :: Nil
  }

  val compteur = new Personnage("chemin") {
  }

  val romulus = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val remus = new CharacterFighter("chemin") {
    var str = 3
    var agi = 3
    var defe = 2
    val arme = new RodStandard
    val spearMercenary = new IceMagic {
      val listAtk = (true, base) :: Nil
    }
    var techniquesCombat = spearMercenary :: Nil
  }

  val inscripteur = new Personnage("chemin") {
  }

  val characterMerchant = new Personnage("chemin") {}

  val marchandDeplca = new SellerJob(characterMerchant, Nil) {
  }

  val lambda1 = new Personnage("chemin") {
  }

  val lambda2 = new Personnage("chemin") {
  }

  val lambda3 = new Personnage("chemin") {
  }
}
