//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainFrame;
import view.PlayerAddDialog;

// Button to access the dialog box for a new player
public class AddPlayerButtonController implements ActionListener {
	
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	private JDialog dialog;
	private Component viewComponent;

	public AddPlayerButtonController(MainFrame mainFrame, GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unused")
		PlayerAddDialog playerAddDialog = new PlayerAddDialog(getGameEngine(), getMainFrame());
	}
	
	public GameEngine getGameEngine() 
	{
		return this.gameEngine;
	}

	public Component getViewComponent() 
	{
		return this.viewComponent;
	}
	
	public JDialog getDialog() 
	{
		return this.dialog;
	}
	
	public MainFrame getMainFrame() 
	{
		return this.mainFrame;
	}	

}
