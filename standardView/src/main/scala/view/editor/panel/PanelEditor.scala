package view.editor.panel

import java.awt.Graphics
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel

import editor.model.ModelEditor
import view.standard.perso.ViewPerso

class PanelEditor(_model: ModelEditor) extends JPanel {

  val model = _model

  var viewPerso = new ViewPerso(model.currentPerso)

  override def paintComponent(g: Graphics) {
    viewPerso.nextImg(model)
    g.drawImage(ImageIO.read(new File(model.currentMap.img)), 0, 0, this)
    g.drawImage(ImageIO.read(new File(viewPerso.currentDirectionEtape)), viewPerso.perso.x, viewPerso.perso.y,
      this)
    model.mutableZoneWalking.foreach(a => g.drawRect(a._1 + 15, a._2 + 30, 15, 1))
  }

}
