package io.github.atomam241;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TakeDraw extends JPanel {

	public static int[] cornX = new int[60];
	public static int[] cornY = new int[60];

	Color hover = new Color(0, 0, 0, 55);
	Color tranRED = new Color(255, 0, 0, 127);

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.drawRect(80, 80, 200, 400);
		g.drawRect(10, 80, 60, 400);
		g.drawRect(290, 80, 60, 400);

		g.drawString("Player 1", 20, 70);
		g.drawString("Player 2", 300, 70);

		int y = 1, x = 1;

		cornX[0] = -100;
		cornY[0] = -100;
				
		for (int i = 1; i <= 50; i++) {

			g.drawRect(40 + (40 * x), 40 + (40 * y), 40, 40);
			cornX[i] = 40 + (40 * x);
			cornY[i] = 40 + (40 * y);
			g.drawString(Integer.toString(i), 55 + (40 * x), 64 + (40 * y));

			x++;
			if (i % 5 == 0) {
				x = 1;
				y++;
			}

		}

		g.setColor(hover);
		g.fillRect(cornX[YouTake.hov], cornY[YouTake.hov], 40, 40);

		
		for (int c : YouTake.crossoutp1) {//player 1 boxes

			g.setColor(tranRED);
			g.fillRect(cornX[c], cornY[c], 40, 40);

		}
		for (int c : YouTake.crossoutp2) {//player 2 boxes

			g.setColor(tranRED);
			g.fillRect(cornX[c], cornY[c], 40, 40);

		}

	}

}
