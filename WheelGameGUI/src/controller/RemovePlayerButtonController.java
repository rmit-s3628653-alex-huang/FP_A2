//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

// Remove player button
public class RemovePlayerButtonController implements ActionListener {

	private Player player;
	private MainFrame mainFrame;
	private GameEngine gameEngine;

	public RemovePlayerButtonController(Player player, MainFrame mainFrame, GameEngine gameEngine) {
		this.player = player;
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}
	
	// remove player from the game, decrement player count
	@Override
	public void actionPerformed(ActionEvent e) {
		getGameEngine().removePlayer(player);
		getMainFrame().getSummaryPanelMain().updateSummary(gameEngine, mainFrame, false);
		getMainFrame().getStatusBarPanel().setPlayerCountLabel(gameEngine);
	}

	public GameEngine getGameEngine() {
		return this.gameEngine;
	}

	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

}
