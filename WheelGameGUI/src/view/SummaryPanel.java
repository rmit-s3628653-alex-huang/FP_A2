//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BetButtonController;
import controller.RemovePlayerButtonController;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

// Summary panel of the player
@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {
	JPanel playerPanel = new JPanel();
	JLabel nameLabel;
	JLabel pointsLabel;
	JLabel betLabel = new JLabel("bet: ", JLabel.RIGHT);
	JTextField betAmount = new JTextField("0");
	JLabel namePlayerLabel;
	JButton betButton = new JButton("Bet");
	JButton removePlayerButton = new JButton("Remove Player");
	int id;
	static int rows = 1;
	static int columns = 5;	
	private JComboBox<BetType> betType = new JComboBox<BetType>(BetType.values());
	private boolean betPlaced;
	
	// Initialise player panel
	public SummaryPanel(Player player, GameEngine gameEngine, MainFrame mainFrame, Boolean spinning) {
		playerPanel.setLayout(new GridLayout(rows, columns));
		id = Integer.parseInt(player.getPlayerId());
		nameLabel = new JLabel("player: " + player.getPlayerName() + " ");
		pointsLabel = new JLabel("current points: " + player.getPoints() + " ");
		playerPanel.add(nameLabel);
		playerPanel.add(pointsLabel);
		playerPanel.add(betLabel);
		playerPanel.add(betAmount);
		playerPanel.add(betType);
		playerPanel.add(betButton);
		playerPanel.add(removePlayerButton);
		
//		// Points/Loss Work in Progress
//		if (spinning) {
//		betButton.setEnabled(false);
//		removePlayerButton.setEnabled(false);
//		betAmount.setEnabled(false);
//		betType.setEnabled(false);
//		}
		
		add(playerPanel);
		
		betButton.addActionListener(new BetButtonController(this, gameEngine, mainFrame));
		removePlayerButton.addActionListener(new RemovePlayerButtonController (player, mainFrame, gameEngine));
	}

	public void updateSummary(MainFrame mainFrame) {
		
	}

	public Integer getId() {
		return id;
	}
	
	public JTextField getBetAmount() {
		return betAmount;
	}
	
	public JComboBox<BetType> getBetType() {
		return betType;
	}
	
	public void setBetPlaced(boolean bet) {
		this.betPlaced  = bet;
	}
	
	public boolean getBetPlaced() {
		return this.betPlaced;
	}
	// Lock input so user can't mess with system when spinning
	public void lockInput(Player player) {
		betButton.setEnabled(false);
		removePlayerButton.setEnabled(false);
		betAmount.setEnabled(false);
		betType.setEnabled(false);
	}
	
}
