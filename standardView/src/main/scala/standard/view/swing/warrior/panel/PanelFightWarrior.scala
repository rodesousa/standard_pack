package standard.view.swing.warrior.panel

import java.awt.{Color, Font, Graphics}
import java.io.File
import javax.imageio.ImageIO

import standard.resources.Variables
import standard.view.swing.panel.PanelFight
import standard.view.swing.warrior.aspect.fight.InfoFightWarrior

/**
 * * Created by rds on 18/05/15.
 */
class PanelFightWarrior(infoFight: InfoFightWarrior) extends PanelFight(infoFight) {
  val model = infoFight.model


  override def paintComponent(g: Graphics) {
    g.drawImage(ImageIO.read(new File(Variables.NOIR)), 0, 0, this)
    g.drawImage(ImageIO.read(new File(infoFight.mapfight)), 120, 200, this)

    val font = new Font("Courier", Font.BOLD, 20)
    g.setFont(font)
    g.setColor(Color.red)

    g.drawString(model.atacker.info.name, 130, 230)
    g.drawString(s"${model.atacker.hpCurrent} / ${model.atacker.hpMax}", 130, 255)

    g.drawString(model.defenser.info.name, 500, 230)
    g.drawString(s"${model.defenser.hpCurrent} / ${model.defenser.hpMax}", 500, 255)

    g.drawImage(ImageIO.read(new File(infoFight.curseurMenu.path)), infoFight.curseurMenu.ele.x,
      infoFight.curseurMenu.ele.y - infoFight.curseurMenu.difToPlace, this)
    g.drawString(infoFight.menu.technique.name, infoFight.menu.technique.x, infoFight.menu.technique.y)
    g.drawString(infoFight.menu.fuite.name, infoFight.menu.fuite.x, infoFight.menu.fuite.y)

    if ((infoFight.curseurCurrent eq infoFight.curseurTechnique) || (infoFight.curseurCurrent eq infoFight.curseurAction)) {
      g.drawImage(ImageIO.read(new File(infoFight.curseurTechnique.path)), infoFight.curseurTechnique.ele.x,
        infoFight.curseurTechnique.ele.y - infoFight.curseurTechnique.difToPlace, this)
      infoFight.listTechnique.foreach(e => g.drawString(e.tech.name, e.x, e.y))
    }

    if (infoFight.curseurCurrent eq infoFight.curseurAction) {
      g.drawImage(ImageIO.read(new File(infoFight.curseurAction.path)), infoFight.curseurAction.ele.x, infoFight.curseurAction.ele.y - infoFight.curseurAction.difToPlace, this)
      infoFight.listAction.foreach(e => g.drawString(e.action.name, e.x, e.y))
    }
  }
}
