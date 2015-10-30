package view.swing.warrior.panel

import java.awt.{Color, Font, Graphics}
import java.io.File
import javax.imageio.ImageIO

import controller.warrior.fight.ControllerFightWarrior
import view.swing.standard.panel.PanelFight
import view.swing.warrior.fight.ViewModelFightWarrior
import view.swing.warrior.fight.zone.{AreaAction, AreaTechniques, AreaMenu}
import warrior.fight.ModelFightWarrior

/**
 * * Created by rds on 18/05/15.
 */
class PanelFightWarrior() extends PanelFight() {
  var viewModelFight: ViewModelFightWarrior = null

  def initViewModelFight(controllerFight: ControllerFightWarrior) {
    this.viewModelFight = new ViewModelFightWarrior(controllerFight)
  }

  override def paintComponent(g: Graphics) {

    val font = new Font("Courier", Font.BOLD, 20)
    g.setFont(font)
    g.setColor(Color.red)

    // print MAP
    g.drawImage(ImageIO.read(new File(viewModelFight.fond)), 0, 0, this)
    g.drawImage(ImageIO.read(new File(viewModelFight.mapFight)), 120, 200, this)

    // PRINT LIFE
    g.drawString(viewModelFight.modelFight.atacker.info.name, 130, 230)
    g.drawString(s"${viewModelFight.modelFight.atacker.hpCurrent} / ${viewModelFight.modelFight.atacker.hpMax}", 130, 255)
    g.drawString(viewModelFight.modelFight.defenser.info.name, 500, 230)
    g.drawString(s"${viewModelFight.modelFight.defenser.hpCurrent} / ${viewModelFight.modelFight.defenser.hpMax}", 500, 255)

    //PRINT CURSEUR
    g.drawImage(ImageIO.read(new File(viewModelFight.curseurImage)), viewModelFight.areaCurrent.x,
      viewModelFight.areaCurrent.y, this)

    // affiche les actionFight
    if (viewModelFight.areaAction != null) {
      if (viewModelFight.areaAction.mustPrint)
        g.drawString(viewModelFight.areaAction.elementCurrent.get.name, viewModelFight.areaAction.x, viewModelFight.areaAction.y + 18)
      if (viewModelFight.areaAction != null && viewModelFight.areaAction.elementNext.isDefined)
        g.drawString(viewModelFight.areaAction.elementNext.get.name, viewModelFight.areaAction.x, viewModelFight.areaAction.y + 58)
    }

    //affiche les techniques
    if (viewModelFight.areaTechniques.mustPrint) {
      g.drawString(viewModelFight.areaTechniques.elementCurrent.get.name, viewModelFight.areaTechniques.x, viewModelFight.areaTechniques.y + 18)
      if (viewModelFight.areaTechniques.elementNext.isDefined)
        g.drawString(viewModelFight.areaTechniques.elementNext.get.name, viewModelFight.areaTechniques.x, viewModelFight.areaTechniques.y + 58)
    }

    // affiche le MENU
    g.drawString(viewModelFight.areaMenu.elementCurrent.get.name, viewModelFight.areaMenu.x, viewModelFight.areaMenu.y + 18)
    if (viewModelFight.areaMenu.elementNext.isDefined)
      g.drawString(viewModelFight.areaMenu.elementNext.get.name, viewModelFight.areaMenu.x, viewModelFight.areaMenu.y + 58)

    if (viewModelFight.modelFight.atacker.die)
      g.drawString("YOU LOOSE", 350, 230)

    if (viewModelFight.modelFight.defenser.die)
      g.drawString("YOU WIN", 350, 230)
  }

}
