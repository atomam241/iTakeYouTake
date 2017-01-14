package io.github.atomam241;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartDraw extends JPanel {

	public static int[] yesnX = new int[5];
	public static int[] yesnY = new int[5];

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(50, 55, 60, 20);
		g.fillRect(50, 80, 60, 20);
		g.fillRect(190, 70, 60, 20);

		yesnX[1] = 50;
		yesnX[2] = 190;
		yesnY[1] = 55;
		yesnY[2] = 70;
		yesnX[3] = 50;
		yesnY[3] = 80;

		g.drawString("Do you want an AI?", 100, 40);

		g.setColor(Color.BLUE);

		if (TakeStart.hover == 1) {
			g.fillRect(50, 55, 60, 20);

		} else if (TakeStart.hover == 2) {
			g.fillRect(190, 70, 60, 20);
		} else if (TakeStart.hover == 3) {
			g.fillRect(50, 80, 60, 20);
		}

		g.setColor(Color.WHITE);
		g.drawString("Yes as P2", 53, 70);
		g.drawString("Yes as P1", 53, 95);
		g.drawString("No", 212, 85);

	}
}
