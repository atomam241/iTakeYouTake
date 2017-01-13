package io.github.atomam241;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ITake extends JFrame implements ActionListener {

	public ITake() {
		super("I'll Take, You'll Take");
		Container c = getContentPane();
		c.add(new TakeDraw());

		c.addMouseListener(new YouTake());
		c.addMouseMotionListener(new YouTake());

		Timer clock = new Timer(30, this);
		clock.start();

	}

	public static void game(String[] args) {

			ITake frame = new ITake();

			frame.setSize(367, 560);
			frame.setLocationRelativeTo(null);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();
	}

}
