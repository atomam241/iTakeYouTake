package io.github.atomam241;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Network extends JFrame implements ActionListener, MouseListener, MouseMotionListener {	
	
	public Network() {
		super("Multiplayer Networking?");
		Container c = getContentPane();
		c.add(new NetDraw());

		c.addMouseListener(this);
		c.addMouseMotionListener(this);

		Timer clock = new Timer(30, this);
		clock.start();

	}
	
	static int hover = 0, click = 0;
	
	
	public static void window() {

		// ImageIcon img = new
		// ImageIcon("src/io/github/atomam241/ic_launcher.png");
		Network frame = new Network();

		frame.setIconImage(TakeStart.image);
		
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

	}

	
	
	public static void server() {

		try {
			ServerSocket ss = new ServerSocket(20017);
			Socket s = ss.accept();// establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("message= " + str);
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		hover = TakeStart.mouse(e.getX(), e.getY(), NetDraw.NetynX, NetDraw.NetynY);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		click = TakeStart.mouse(e.getX(), e.getY(), NetDraw.NetynX, NetDraw.NetynY);
		
		
		if (click == 1) {// Yes
			server();			
		} else if (click == 2) {// NO
			this.setVisible(false);
			ITake.game();
		}else if (click == 3){
			
		}

	}
}
