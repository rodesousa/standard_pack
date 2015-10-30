package view.swing.standard.panel

import javax.swing.JPanel

import view.swing.warrior.fight.ViewModelFightWarrior

/**
 * * Created by rds on 16/05/15.
 */
abstract class PanelFight() extends JPanel {
  def viewModelFight: ViewModelFightWarrior
}
