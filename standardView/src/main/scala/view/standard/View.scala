package view.standard

import java.awt.GridLayout
import javax.swing.{JFrame, JPanel}

import controller.standard.Controller
import standard.model.model.Model
import view.standard.fight.ViewModelFigth
import view.standard.listener.{Listener, ListenerFight}
import view.standard.panel.{PanelFight, PanelHome}

abstract class View(_controller: Controller) extends JFrame {
  def model: Model

  def panelGame: JPanel

  def panelFight: PanelFight

  def keyboardListener: Listener

  def keyboardFightListener: ListenerFight

  def controller: Controller

  def panelHome: PanelHome

  def deleteFight

  def initFight(infoFight: ViewModelFigth): Unit = {
    //    panelFight.infoFight = infoFight
    println(???)
  }

  def init() {
    panelHome.add(panelGame)
    panelHome.addKeyListener(keyboardListener)
    panelHome.addMouseListener(keyboardListener)
    panelHome.setFocusable(true)
    panelHome.setLayout(new GridLayout(1, 0))
    this.setTitle("TestJeux")
    this.setSize(1000, 1000)
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    this.setContentPane(panelHome)
    this.setVisible(true)
    panelHome.setVisible(true)
  }

  def removeListenerFight(): Unit = {
    panelHome.removeKeyListener(keyboardFightListener)
    panelHome.addKeyListener(keyboardListener)
  }

}
