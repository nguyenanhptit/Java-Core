package bai9;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

public class AWTListenerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Frame screen = new Frame();
	screen.addWindowListener((WindowClosing)(e)->System.exit(1));
	Button button = new Button("press me");
	screen.add(button);
	button.addActionListener(e ->JOptionPane.showMessageDialog(null, "Info Box: Welcome to java by example", "java sample", JOptionPane.INFORMATION_MESSAGE)
			);
	screen.setSize(250,400);
	screen.setVisible(false);
	}
}
