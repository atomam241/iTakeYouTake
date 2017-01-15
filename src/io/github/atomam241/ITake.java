package io.github.atomam241;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

	public static void game() {

			ITake frame = new ITake();

			try {
				frame.setIconImage(ImageIO.read(new File("src/io/github/atomam241/img/ic_launcher.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
