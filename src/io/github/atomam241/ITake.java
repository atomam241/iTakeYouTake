package io.github.atomam241;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ITake extends JFrame {

	public ITake() {
		super("I'll Take, You'll Take");
		Container c = getContentPane();
		c.add(new Graphic());

	}

	public static void main(String[] args) {
		ITake frame = new ITake();

		frame.setSize(367, 560);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}

