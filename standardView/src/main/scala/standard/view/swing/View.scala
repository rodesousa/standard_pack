package standard.view.swing

import java.awt.event.{KeyListener, MouseListener}
import javax.swing.{JFrame, JPanel}

import standard.controller.Controller
import standard.model.Model

abstract class View(_controller: Controller) extends JFrame {
  /////Debbut Constructeur/////
  def panelFight: JPanel

  def keyboardListener: KeyListener with MouseListener
}
