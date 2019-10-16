//Further Programming Assignment 2 by Alex Huang s3628653
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.MainFrame;
import view.SummaryPanel;

// Force spin button
public class SpinButtonController implements ActionListener {

	private MainFrame mainFrame;
	private GameEngine gameEngine;
	private boolean allBets = true;
	private BetType betType;

	public SpinButtonController(MainFrame mainFrame, GameEngine gameEngine) {
		this.mainFrame = mainFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.getSummaryPanelMain().updateSummary(gameEngine, mainFrame, true);
		mainFrame.getFunctionsPanel().lockButtons(true);

		for (SummaryPanel panel : getMainFrame().getSummaryPanelMain().getAllPanels()) {
			if (!panel.getBetPlaced()) {
				// Place a zero bet for players who haven't bet
				betType = (BetType) panel.getBetType().getSelectedItem();
				getGameEngine().getPlayer(Integer.toString(panel.getId())).setBet(0);
				getGameEngine().getPlayer(Integer.toString(panel.getId())).setBetType(betType);
				panel.lockInput(getGameEngine().getPlayer(Integer.toString(panel.getId())));
			}
		}
		// Only run if all bets have been placed
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

	public GameEngine getGameEngine() {
		return this.gameEngine;
	}

	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

}
