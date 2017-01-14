package io.github.atomam241;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TakeDraw extends JPanel {

	public static int[] cornX = new int[60];
	public static int[] cornY = new int[60];

	Color hover = new Color(0, 0, 0, 55);
	Color player1 = new Color(255, 0, 0, 127);
	Color player2 = new Color(0, 0, 255, 127);
	static String pl2 = "Player2";

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.drawRect(80, 80, 200, 400);
		g.drawRect(10, 80, 60, 400);
		g.drawRect(290, 80, 60, 400);

		g.drawString("Player 1", 20, 70);
		g.drawString(pl2, 292, 70);
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

		int p1 = 1, p2 = 1, p1tot = 0, p2tot = 0, p1y = 0, p2y = 0, p1x = 0, p2x = 0;
		for (int c : YouTake.crossoutp1) {//player 1 boxes

			g.setColor(Color.BLACK);
			if (p1y > 460){
				p1 = 1;
				p1x += 25;
			}
			p1y = 90+(p1*12);
			g.drawString(Integer.toString(c), 20 + p1x, p1y);
			g.setColor(player1);
			g.fillRect(cornX[c], cornY[c], 40, 40);
			p1++;
			p1tot += c;
			
		}
		for (int c : YouTake.crossoutp2) {//player 2 boxes

			g.setColor(Color.BLACK);
			if (p2y > 460){
				p2 = 1;
				p2x += 25;
			}
			p2y = 90+(p2*12);
			g.drawString(Integer.toString(c), 300 + p2x, p2y);;
			g.setColor(player2);
			g.fillRect(cornX[c], cornY[c], 40, 40);
			p2++;
			p2tot += c;

		}
		
		if(YouTake.turn % 2 == 0){
			g.setColor(player2);
			g.fillRect(290, 58, 50, 15);
			
		}else{
			g.setColor(player1);
			g.fillRect(18, 58, 50, 15);
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Total: " + Integer.toString(p1tot), 20, 500);
		g.drawString("Total: " + Integer.toString(p2tot), 300, 500);

	}

}
