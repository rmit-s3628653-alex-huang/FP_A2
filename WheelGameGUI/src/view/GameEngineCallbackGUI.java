//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private MainFrame mainFrame;

	public GameEngineCallbackGUI(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		mainFrame.getStatusBarPanel().setStatusLabel("Spinning");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mainFrame.getWheelPanel().updateBall(slot);
			}
		});

	}

	@Override
	public void result(Slot winningSlot, GameEngine engine) {
		getMainFrame().getStatusBarPanel().setResultLabel(winningSlot.toString());
		mainFrame.getSummaryPanelMain().updateSummary(engine, mainFrame, false);
		mainFrame.getFunctionsPanel().lockButtons(false);
		mainFrame.getStatusBarPanel().setStatusLabel("Ready to Spin");

	}

	public MainFrame getMainFrame() {
		return this.mainFrame;
	}

}
