package standard.view.swing


import java.awt.GridLayout
import javax.swing.{JFrame, JPanel}
import controller.standard.Controller
import standard.model.model.Model
import standard.view.swing.fight.InfoFIght
import standard.view.swing.listener.Listener
import standard.view.swing.panel.{PanelFight, PanelHome}

abstract class View(_controller: Controller) extends JFrame {
  def model: Model

  def panelGame: JPanel

  def panelFight: PanelFight

  def keyboardListener: Listener

  def keyboardFightListener: Listener

  def controller: Controller

  def panelHome: PanelHome

  def initFight

  def deleteFight
//    panelFight = null


  def init() {
    panelHome.add(panelGame)
    panelHome.addKeyListener(keyboardListener)
    panelHome.addMouseListener(keyboardListener)
    panelHome.setFocusable(true)
    panelHome.setLayout(new GridLayout(1, 1))
    this.setTitle("TestJeux")
    this.setSize(800, 600)
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    this.setContentPane(panelHome)
    this.setVisible(true)
  }

}
