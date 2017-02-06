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

		g.setColor(Color.BLACK);
		g.fillRect(50, 55, 60, 20);
		g.fillRect(50, 80, 60, 20);
		g.fillRect(190, 70, 60, 20);

		NetynX[1] = 50;
		NetynY[1] = 55;
		NetynX[2] = 190;
		NetynY[2] = 70;
		NetynX[3] = 50;
		NetynY[3] = 80;

		g.drawString("Do you want to play Multiplayer over the Network?", 10, 40);

		g.setColor(Color.BLUE);

		if (TakeStart.hover == 1) {
			g.fillRect(NetynX[1], NetynY[1], 60, 20);

		} else if (TakeStart.hover == 2) {
			g.fillRect(NetynX[2], NetynY[2], 60, 20);
		} else if (TakeStart.hover == 3) {
			g.fillRect(NetynX[3], NetynY[3], 60, 20);
		}

		g.setColor(Color.WHITE);
		g.drawString("Server", NetynX[1]+12, NetynY[1]+15);
		g.drawString("Client", NetynX[3]+12, NetynY[3]+15);
		g.drawString("No", NetynX[2]+22, NetynY[2]+15);
	}
}