//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.SummaryPanel;
// Overall panel which contains every player panel
@SuppressWarnings("serial")
public class SummaryPanelMain extends JPanel {

	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
	private SummaryPanel summaryPanel;
	private ArrayList<SummaryPanel> playerPanels;
	private final int rows = 4;
	private final int columns = 9;
	public SummaryPanelMain(GameEngine gameEngine, MainFrame mainFrame) {
		setLayout(new GridLayout(rows, columns));
	}

	public void updateSummary(GameEngine gameEngine, MainFrame mainFrame, Boolean spinning) {
		setLayout(new GridLayout(gameEngine.getAllPlayers().size(), columns));
		playerPanels = new ArrayList<SummaryPanel>();
		for (Player player : gameEngine.getAllPlayers()) {
			playerPanels.add(new SummaryPanel(player, gameEngine, mainFrame, spinning));
		}

		this.removeAll();
		setBorder(blackBorder);
		for (SummaryPanel panel : playerPanels) {
			add(panel);
		}
		repaint();
		revalidate();
	}

	public SummaryPanel getSummaryPanel() {
		return summaryPanel;
	}

	public List<SummaryPanel> getAllPanels() {
		return playerPanels;
	}

}