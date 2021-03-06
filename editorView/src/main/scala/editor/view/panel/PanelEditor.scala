package editor.view.panel

import java.awt.Graphics
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel

import editor.model.ModelEditor
import standard.view.swing.perso.ViewPerso

class PanelEditor(_model: ModelEditor) extends JPanel {

  val model = _model

  var viewPerso = new ViewPerso(model.currentPerso)

  override def paintComponent(g: Graphics) {
    viewPerso.nextImg(model)

    g.drawImage(ImageIO.read(new File(model.currentMap.img)), 0, 0, this)
    g.drawImage(ImageIO.read(new File(viewPerso.currentDirectionEtape)), viewPerso.perso.x, viewPerso.perso.y,
      this)

    model.list.foreach(p => println(p._1))
  }

}
