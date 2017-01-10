package io.github.atomam241;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class YouTake implements MouseListener {
	
	
	static List<Integer> crossout = new ArrayList<Integer>();
	
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
		
		/*System.out.println("Press:" + clicked(e.getX(), e.getY()));
		System.out.println(e.getX() + " " + e.getY());*/
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
		int clicked = clicked(e.getX(), e.getY());
		
		if(clicked != -1 && !crossout.contains(clicked)){
			crossout.add(clicked);
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
}
