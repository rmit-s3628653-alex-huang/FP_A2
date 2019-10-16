//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.MainFrame;
import view.PlayerAddDialog;

// Button to Add Player taking in the entered name and points
public class AddButtonController implements ActionListener {

	private GameEngine gameEngine;
	private MainFrame mainFrame;
	private JDialog dialog;
	private String stringPoints;
	private String name;
	private int points;

	public AddButtonController(JDialog dialog, MainFrame mainFrame, GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PlayerAddDialog dialog = (PlayerAddDialog) getDialog();
		stringPoints = dialog.getPointsField().getText();
		if (checkValidInteger(stringPoints)) {
			name = dialog.getNameField().getText();
			points = Integer.parseInt(dialog.getPointsField().getText());
			String playerCount = Integer.toString(getGameEngine().getAllPlayers().size());
			SimplePlayer tempPlayer = new SimplePlayer(playerCount, name, points);
			getGameEngine().addPlayer(tempPlayer);
			getMainFrame().getStatusBarPanel().setPlayerCountLabel(gameEngine);
			getDialog().dispose();
			getMainFrame().getSummaryPanelMain().updateSummary(gameEngine, mainFrame, false);
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Points");
		}
	}

	public boolean checkValidInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}

	}

	public GameEngine getGameEngine() {
		return this.gameEngine;
	}

	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

	public JDialog getDialog() {
		return this.dialog;
	}

}
