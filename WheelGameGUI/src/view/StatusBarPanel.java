//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

// Status bar
@SuppressWarnings("serial")
public class StatusBarPanel extends JPanel implements PropertyChangeListener {
	private JLabel resultLabel = new JLabel("Result: Not Spun", JLabel.LEFT);
	private JLabel spinStatusLabel = new JLabel("Ready to Spin", JLabel.CENTER);
	private JLabel playerCountLabel = new JLabel("Player Count: ", JLabel.RIGHT);

	public StatusBarPanel() {
		setLayout(new GridLayout(1, 3));

		resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		spinStatusLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		playerCountLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		add(resultLabel);
		add(spinStatusLabel);
		add(playerCountLabel);
	}

	public void setResultLabel(String result) {
		this.resultLabel.setText("Result: " + result);
	}

	public void setStatusLabel(String string) {
		this.spinStatusLabel.setText(string);
	}

	public void setPlayerCountLabel(GameEngine gameEngine) {
		this.playerCountLabel.setText("Player Count: " + gameEngine.getAllPlayers().size());
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

	}

}
