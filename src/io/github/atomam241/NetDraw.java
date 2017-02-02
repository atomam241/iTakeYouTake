package io.github.atomam241;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NetDraw extends JPanel {

	public static int[] NetynX = new int[5];
	public static int[] NetynY = new int[5];

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawString("Do you want to play multiplayer over network?", 30, 40);

		g.setColor(Color.BLACK);
		g.fillRect(50, 70, 60, 20);
		g.fillRect(190, 70, 60, 20);

		NetynX[1] = 50;
		NetynY[1] = 70;
		NetynX[2] = 190;
		NetynY[2] = 70;

		g.setColor(Color.BLUE);

		if (Network.hover == 1) {
			g.fillRect(NetynX[1], NetynY[1], 60, 20);

		} else if (Network.hover == 2) {
			g.fillRect(NetynX[2], NetynY[2], 60, 20);
			
		}
		g.setColor(Color.WHITE);
		g.drawString("Yes as P2", NetynX[1] + 3, NetynY[1] + 15);
		g.drawString("Yes as P1", NetynX[3] + 3, NetynY[3] + 15);
		g.drawString("No", NetynX[2] + 22, NetynY[2] + 15);
	}
}