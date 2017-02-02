package io.github.atomam241;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
	static URL url = TakeStart.class.getResource("/io/github/atomam241/img/ic_launcher.png");
	static Image image = null;
	

	public static void main(String[] args) {

		// ImageIcon img = new
		// ImageIcon("src/io/github/atomam241/ic_launcher.png");
		TakeStart frame = new TakeStart();

		url = TakeStart.class.getResource("/io/github/atomam241/img/ic_launcher.png");
		
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setIconImage(image);
		
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
		hover = mouse(e.getX(), e.getY(), StartDraw.yesnX, StartDraw.yesnY);

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

		click = mouse(e.getX(), e.getY(), StartDraw.yesnX, StartDraw.yesnY);

		if (click == 1) {// YES p2
			new TakeStart();
			this.setVisible(false);
			TakeDraw.pl2 = "HAL the AI";
			Aip2 = true;
			ITake.game();
		} else if (click == 2) {// NO
			new TakeStart();
			this.setVisible(false);
			Network.window();
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

	public static int mouse(int x, int y, int[] Xarr, int[] Yarr) {

		int number = 0;
		for (int i = 1; i <= (Xarr.length-1); i++) {

			if ((x > Xarr[i]) && (x < Xarr[i] + 60) && (y > Yarr[i])
					&& (y < Yarr[i] + 20)) {
				number = i;
				break;
			}

		}
		return number;
	}

}