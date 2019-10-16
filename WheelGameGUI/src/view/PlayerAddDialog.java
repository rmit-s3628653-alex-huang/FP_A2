//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddButtonController;
import controller.CancelButtonController;
import model.interfaces.GameEngine;
// Add Dialog Box
@SuppressWarnings("serial")
public class PlayerAddDialog extends JDialog {
	
	private JLabel nameLabel = new JLabel("Player Name: ");
	private JTextField nameField = new JTextField();
	private JLabel pointsLabel = new JLabel("Starting Points: ");
	private JTextField pointsField = new JTextField("2000");
	private JButton addButton = new JButton("Add Player");
	private JButton cancelButton = new JButton("Cancel");
	private JDialog dialog;
	// Initialise add player dialog box information
	public PlayerAddDialog(GameEngine gameEngine, MainFrame mainFrame) {
		
		setTitle("Add Player");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new GridLayout(0,2));
		add(nameLabel);
		nameField.setColumns(20);
		add(nameField);
		add(pointsLabel);
		pointsField.setColumns(10);
		add(pointsField);
		add(addButton);
		add(cancelButton);
		addButton.addActionListener(new AddButtonController(this, mainFrame, gameEngine));
		cancelButton.addActionListener(new CancelButtonController(this, mainFrame, gameEngine));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		

		
	}
	
	public JTextField getNameField() {
		return this.nameField;
	}
	
	public JTextField getPointsField() {
		return this.pointsField;
	}
	
	public JDialog getDialog() 
	{
		return this.dialog;
	}

}
