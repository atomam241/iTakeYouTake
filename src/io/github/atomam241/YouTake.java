package io.github.atomam241;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class YouTake implements MouseListener, MouseMotionListener {

	static List<Integer> crossoutp1 = new ArrayList<Integer>();
	static List<Integer> crossoutp2 = new ArrayList<Integer>();
	static int hov = 0;
	int turn = 1;

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

		if (turn % 2 == 0) { //player2
			if (clicked != -1 && !crossoutp1.contains(clicked) && !crossoutp2.contains(clicked)) {
				crossoutp2.add(clicked);
				turn++;
				System.out.println("player 2");
			}
		}else{ //player 1
			if (clicked != -1 && !crossoutp1.contains(clicked) && !crossoutp2.contains(clicked)) {
				crossoutp1.add(clicked);
				turn++;
				System.out.println("player 1");
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
