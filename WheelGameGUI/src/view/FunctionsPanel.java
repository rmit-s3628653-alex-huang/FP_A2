//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.AddPlayerButtonController;
import controller.SpinButtonController;
import model.interfaces.GameEngine;

// Toolbar panel
@SuppressWarnings("serial")
public class FunctionsPanel extends JPanel {
	private JToolBar toolBar = new JToolBar("Functions ToolBar");
	private JButton addPlayerButton = new JButton("Add Player");
	private JButton removePlayerButton = new JButton("Remove Player");
	private JButton spinButton = new JButton("Spin Wheel");

	public FunctionsPanel(GameEngine gameEngine, MainFrame mainFrame, Boolean spinning) {
		setLayout(new FlowLayout());

		toolBar.add(addPlayerButton);
		toolBar.add(spinButton);
		add(toolBar);

		addPlayerButton.addActionListener(new AddPlayerButtonController(mainFrame, gameEngine));
		spinButton.addActionListener(new SpinButtonController(mainFrame, gameEngine));
	}

	public void lockButtons(boolean spinning) {
		addPlayerButton.setEnabled(!spinning);
		spinButton.setEnabled(!spinning);
	}

	public JButton getAddPlayerButton() {
		return addPlayerButton;
	}

	public JButton getRemovePlayerButton() {
		return removePlayerButton;
	}

	public JButton getSpinButton() {
		return spinButton;
	}
}
