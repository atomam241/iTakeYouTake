package io.github.atomam241;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class YouTake implements MouseListener, MouseMotionListener {

	static List<Integer> crossoutp1 = new ArrayList<Integer>();
	static List<Integer> crossoutp2 = new ArrayList<Integer>();
	static List<Integer> aichoose = new ArrayList<Integer>();
	static int hov = 0, turn = 1;
	static boolean start = true;

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		/*
		 * System.out.println("Press:" + clicked(e.getX(), e.getY()));
		 * System.out.println(e.getX() + " " + e.getY());
		 */

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		int clicked = clicked(e.getX(), e.getY());

		if (turn % 2 == 0) { // player2

			if (clicked != -1 && !crossoutp1.contains(clicked) && !crossoutp2.contains(clicked)) {
				crossoutp2.add(clicked);
				factors(clicked);
				turn++;
				ai1();
				// System.out.println("player 2");
			}

		} else { // player 1
			if (clicked != -1 && !crossoutp1.contains(clicked) && !crossoutp2.contains(clicked)) {
				crossoutp1.add(clicked);
				factors(clicked);
				turn++;
				// System.out.println("player 1");
				ai2();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int clicked = clicked(e.getX(), e.getY());

		if (clicked != -1) {
			hov = clicked;
		} else {
			hov = 0;
		}
	}

	private int clicked(int x, int y) {

		int number = -1;
		for (int i = 1; i <= 50; i++) {

			if ((x > TakeDraw.cornX[i]) && (x < TakeDraw.cornX[i] + 40) && (y > TakeDraw.cornY[i])
					&& (y < TakeDraw.cornY[i] + 40)) {
				number = i;
				break;
			}

		}
		return number;

	}

	private static void factors(int number) {

		int factor = 1;

		if (turn % 2 == 0) {// player2
			while (factor <= number) {
				if (number % factor == 0) {
					if (!crossoutp1.contains(factor) && !crossoutp2.contains(factor)) {
						crossoutp1.add(factor);
					}
				}
				factor++;
			}

		} else { // player 1
			while (factor <= number) {
				if (number % factor == 0) {
					if (!crossoutp1.contains(factor) && !crossoutp2.contains(factor)) {
						crossoutp2.add(factor);
					}
				}
				factor++;
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	private static void findfac(int i) {

		// System.out.println(aichoose);
		aichoose.clear();
		int factor = 1;
		while (factor <= i) {
			if (i % factor == 0 && i != factor && !crossoutp1.contains(factor) && !crossoutp2.contains(factor)) {
				aichoose.add(factor);
			}
			factor++;
		}

	}

	static void ai2() {
		if (TakeStart.Aip2) {
			int pick = 1;
			int prevloss = 100;
			int loss = 0;
			for (int i = 50; i > 1; i--) {
				if (!crossoutp1.contains(i) && !crossoutp2.contains(i)) {
					findfac(i);
					int facsum = 0;
					for (int n : aichoose) {
						// System.out.println(n);
						facsum += n;
					}
					loss = facsum - i;
					// System.out.println(i + " with " + loss);
					if (loss < prevloss) {

						pick = i;
						prevloss = loss;
					}
				}
			}

			if (!crossoutp1.contains(pick) && !crossoutp2.contains(pick)) {
				crossoutp2.add(pick);

				factors(pick);
				turn++;
			}
		}
		//ai1(); <--lol
	}

	static void ai1() {

		if (turn % 2 != 0) {
			int pick = 1;
			int prevloss = 100;
			int loss = 0;
			for (int i = 50; i > 1; i--) {
				if (!crossoutp1.contains(i) && !crossoutp2.contains(i)) {
					findfac(i);
					int facsum = 0;
					for (int n : aichoose) {
						// System.out.println(n);
						facsum += n;
					}
					loss = facsum - i;
					// System.out.println(i + " with " + loss);
					if (loss < prevloss) {

						pick = i;
						prevloss = loss;
					}
				}
			}

			if (!crossoutp1.contains(pick) && !crossoutp2.contains(pick)) {
				crossoutp1.add(pick);

				factors(pick);
				turn++;
			}
		}
		//ai2(); <--lol
	}
}
