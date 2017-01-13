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
	
	
	static int hover = 0;
	
	public static void main(String[] args) {

			TakeStart frame = new TakeStart();

			frame.setSize(300,200);
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
		int on = mouse(e.getX(), e.getY());
		
		System.out.println(on);
		
		if(on == -1){
			hover = on;
		}else{
			hover = 0;
		}
		
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
		
	}
	
	public int mouse(int x, int y){
		
		int number = -1;
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