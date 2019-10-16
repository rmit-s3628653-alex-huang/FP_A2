//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.MainFrame;
import view.SummaryPanel;

// Button to add a bet to the system
public class BetButtonController implements ActionListener {

	private Component viewComponent;
	private GameEngine gameEngine;
	private MainFrame mainFrame;
	private String betAmount;
	private int betValue;
	private BetType betType;
	private boolean allBets = true;

	public BetButtonController(Component viewComponent, GameEngine gameEngine, MainFrame mainFrame) {
		this.gameEngine = gameEngine;
		this.mainFrame = mainFrame;
		this.viewComponent = viewComponent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		SummaryPanel summaryPanel = (SummaryPanel) getViewComponent();
		betAmount = summaryPanel.getBetAmount().getText();
		betType = (BetType) summaryPanel.getBetType().getSelectedItem();

		if (checkValidInteger(betAmount)) {

			betValue = Integer.parseInt(betAmount);
			
			if (betValue <= getGameEngine().getPlayer(Integer.toString(summaryPanel.getId())).getPoints() && betValue >= 0) {
				getGameEngine().getPlayer(Integer.toString(summaryPanel.getId())).setBet(betValue);
				getGameEngine().getPlayer(Integer.toString(summaryPanel.getId())).setBetType(betType);

				summaryPanel.setBetPlaced(true);
				summaryPanel.lockInput(getGameEngine().getPlayer(Integer.toString(summaryPanel.getId())));
				for (SummaryPanel panel : getMainFrame().getSummaryPanelMain().getAllPanels()) {
					if (!panel.getBetPlaced()) {
						allBets = false;
						break;
					}
				}
				if (allBets) {
					mainFrame.getFunctionsPanel().lockButtons(true);
					new Thread() {
						@Override
						public void run() {
							getGameEngine().spin(mainFrame.getInitialDelay(), mainFrame.getFinalDelay(),
									mainFrame.getDelayIncrement());
						}
					}.start();

				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Not Enough Points");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Bet, Not A Number");

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

	public Component getViewComponent() {
		return this.viewComponent;
	}
}
