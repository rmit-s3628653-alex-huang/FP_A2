//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

// Main Frame to set all the elements
public class MainFrame {

	private MenuBar MenuGUI;
	private SummaryPanelMain summaryPanelMain;
	private FunctionsPanel functionsPanel;
	private WheelPanel wheelPanel;
	private StatusBarPanel statusBarPanel;

	private final int INITIAL_DELAY = 1;
	private final int FINAL_DELAY = 500;
	private final int INCREMENT_DELAY = 25;
	// Initialise elements
	public MainFrame(GameEngine gameEngine) {
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension minSize = new Dimension((int) screenSize.getWidth()/2, (int) screenSize.getHeight()/2);
		frame.setMinimumSize(minSize);
		frame.setTitle("Further Programming - Assignment 2");
		frame.setSize(new Dimension(960, 800));
		frame.setLayout(new BorderLayout());
		
		
		MenuGUI = new MenuBar(gameEngine, this);
		summaryPanelMain = new SummaryPanelMain(gameEngine, this);
		functionsPanel = new FunctionsPanel(gameEngine, this, false);
		wheelPanel = new WheelPanel();
		statusBarPanel = new StatusBarPanel();

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(functionsPanel, BorderLayout.NORTH);
		panel.add(summaryPanelMain, BorderLayout.CENTER);

		frame.add(wheelPanel, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(statusBarPanel, BorderLayout.SOUTH);
		frame.setJMenuBar(MenuGUI);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public SummaryPanelMain getSummaryPanelMain() {
		return summaryPanelMain;
	}

	public FunctionsPanel getFunctionsPanel() {
		return functionsPanel;
	}

	public StatusBarPanel getStatusBarPanel() {
		return statusBarPanel;
	}

	public WheelPanel getWheelPanel() {
		return wheelPanel;
	}

	public int getInitialDelay() {
		return this.INITIAL_DELAY;
	}

	public int getFinalDelay() {
		return this.FINAL_DELAY;
	}

	public int getDelayIncrement() {
		return this.INCREMENT_DELAY;
	}

}
