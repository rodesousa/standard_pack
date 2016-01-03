package standard.resources

object Variables {

  val PATH_GLOBAL_PROPERTIES = "src\\source\\global.properties"
  val PATH_FOLDER_MAP = "ressources\\source\\map\\"
  val PATH_FOLDER_PERSO = "ressources\\source\\perso\\"

  //Direction
  val DIRECTION_LEFT = "37"
  val DIRECTION_RIGHT = "39"
  val DIRECTION_UP = "38"
  val DIRECTION_DOWN = "40"

  val EVENT_DIALOGUE = "event_dialogue"
  val EVENT_DEPLACEMENT = "event_deplacement"
  val EVENT_FIGHT = "event_fight"
  val EVENT_BEGIN_FIGHT = "event_begin_fight"
  val EVENT_BEGIN = "event_begin"
  val EVENT_NONE = "event_none"
  val EVENT_FIGHT_DONE = "event_fight_done"

  val DEBUG = true

  val listDeplacement = 37 :: 38 :: 39 :: 40 :: 10 :: Nil
  val listFight = 37 :: 38 :: 39 :: 40 :: 10 :: Nil
  val listDialogue = 10 :: Nil

  // WARRIOR
  val PERSONNAGE_NAME = "standardResource/src/main/resources/standard/resources/perso/perso"
  val MAP_NAME = "standardResource/src/main/resources/standard/resources/map/map"
  val MAP_FIGHT = "fight.jpg"
  val BEGIN = "begin"
  val CURSEUR_FIGHT = "menu.jpg"
  val BLACK = "test.jpg"
  val NOTIMPLE = "NOT IMPLEM"
}