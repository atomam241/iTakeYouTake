package io.github.atomam241;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class TakeStart extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	public TakeStart() {
		super("Let's Begin");
		Container c = getContentPane();
		c.add(new StartDraw());

		c.addMouseListener(this);
		c.addMouseMotionListener(this);

		Timer clock = new Timer(30, this);
		clock.start();

	}

	static int hover = 0, click = 0;
	static boolean Aip1 = false, Aip2 = false;

	public static void main(String[] args) {

		TakeStart frame = new TakeStart();

		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		hover = mouse(e.getX(), e.getY());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		click = mouse(e.getX(), e.getY());

		if (click == 1) {// YES p2
			new TakeStart();
			this.setVisible(false);			
			TakeDraw.pl2 = "HAL the AI";
			Aip2 = true;			
			ITake.game();
		} else if (click == 2) {// NO
			new TakeStart();
			this.setVisible(false);
			ITake.game();
		} else if (click == 3) {// YES p1
			new TakeStart();
			this.setVisible(false);	
			TakeDraw.pl1 = "HAL the AI";
			Aip1 = true;			
			ITake.game();
			YouTake.ai1();
		}

		/*
		 * int clk = if (clk != -1) { hover = clk; } else { hover = 0; }
		 */

	}

	public int mouse(int x, int y) {

		int number = 0;
		for (int i = 1; i <= 4; i++) {

			if ((x > StartDraw.yesnX[i]) && (x < StartDraw.yesnX[i] + 60) && (y > StartDraw.yesnY[i])
					&& (y < StartDraw.yesnY[i] + 20)) {
				number = i;
				break;
			}

		}
		return number;
	}

}