package view.standard.panel

import javax.swing.JPanel

import view.warrior.fight.ViewModelFightWarrior

/**
 * * Created by rds on 16/05/15.
 */
abstract class PanelFight() extends JPanel {
  def viewModelFight: ViewModelFightWarrior
}
