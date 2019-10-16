//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainFrame;

// Cancel dialog button
public class CancelButtonController implements ActionListener {

	private GameEngine gameEngine;
	private Component viewComponent;
	private JDialog dialog;
	private MainFrame mainFrame;

	public CancelButtonController(JDialog dialog, MainFrame mainFrame, GameEngine gameEngine) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDialog().dispose();

	}
	
	public JDialog getDialog() {
		return this.dialog;
	}
	
	public GameEngine getGameEngine() 
	{
		return this.gameEngine;
	}

	public Component getViewComponent() 
	{
		return this.viewComponent;
	}

	
	public MainFrame getMainFrame() 
	{
		return this.mainFrame;
	}	

}
