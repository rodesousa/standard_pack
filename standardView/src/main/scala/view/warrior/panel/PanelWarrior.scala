package view.warrior.panel

import java.awt.{Color, Font, Graphics}
import java.io.File
import javax.imageio.ImageIO

import standard.resources.Variables
import view.standard.panel.PanelHome
import view.warrior.perso.ViewPersoWarrior
import warrior.model.ModelWarrior

/**
 * * Created by rds on 07/05/15.
 */
class PanelWarrior(model: ModelWarrior) extends PanelHome {
  var viewPerso = new ViewPersoWarrior(model.currentPerso)

  override def paintComponent(g: Graphics) {
    viewPerso.nextImg(model)
    val font = new Font("Courier", Font.BOLD, 30)

    g.setFont(font)
    g.setColor(Color.red)

    g.drawImage(ImageIO.read(new File(model.currentMap.img)), 0, 0, this)

    g.drawImage(ImageIO.read(new File(viewPerso.currentDirectionEtape)), viewPerso.perso.x, viewPerso.perso.y,
      this)

    if (model.stateGame eq Variables.EVENT_DIALOGUE) {
      println("EVENT_DIALOGUE")
      val font = new Font("Courier", Font.BOLD, 20)
      g.setFont(font)
      g.setColor(Color.red)
      g.drawImage(ImageIO.read(new File(Variables.BLACK)), 0, 400, 680, 150, this)
      g.drawString("Game MASTER", 0, 420)
      g.drawString("NOT IMPL", 0, 480)
    }
  }
}
