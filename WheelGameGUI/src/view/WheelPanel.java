//Further Programming Assignment 2 by Alex Huang s3628653
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.interfaces.Slot;

// Wheel panel to ensure resizing still rolls ball correctly
@SuppressWarnings("serial")
public class WheelPanel extends JPanel {
	private Image wheel;
	private Slot ballSlot;
	private Image scaledWheel;
	private double ballCoordX;
	private double ballCoordY;
	private int d;
	private int x;
	private int y;
	private int radius;
	private int height;
	private int width;
	private double theta;

	public WheelPanel() {

		try {
			wheel = ImageIO.read(new File("Basic_roulette_wheel_1024x1024.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateBall(Slot slot) {
		ballSlot = slot;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Dimension size = this.getSize();
		d = Math.min(size.width, size.height);
		x = (size.width - d) / 2;
		y = (size.height - d) / 2;
		scaledWheel = wheel.getScaledInstance(d, d, Image.SCALE_DEFAULT);
		g.drawImage(scaledWheel, x, y, null);
		radius = (int) ((scaledWheel.getHeight(null) / 2 + scaledWheel.getHeight(null) / 2) / 2 - 10);
		height = (int) (y + (scaledWheel.getHeight(null) / 2 - 8));
		width = (int) (x + scaledWheel.getWidth(null) / 2 - 8);
		if (ballSlot != null) {
			// + 1 to for correct position, -90 to correct radian starting point
			theta = Math.toRadians((ballSlot.getPosition()+1) * 360 / Slot.WHEEL_SIZE - 90);
			ballCoordX = radius * Math.cos(theta) + width;
			ballCoordY = radius * Math.sin(theta) + height;
			g.setColor(new Color(66, 134, 244));
			g.fillOval((int) ballCoordX, (int) ballCoordY, 15, 15);
		}

	}
}
