//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuQuitController;
import model.interfaces.GameEngine;

// Top Menu Pull Down
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private JMenu gameMenu = new JMenu("Options");
	private JMenuItem menuQuit = new JMenuItem("Exit");
	
	public MenuBar(GameEngine gameEngine, MainFrame mainFrame) {
		gameMenu.add(menuQuit);
		add(gameMenu);
		menuQuit.addActionListener(new MenuQuitController());
	}
}
