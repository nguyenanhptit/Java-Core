package Test;

import java.awt.Frame;

import javax.swing.JFrame;

public class AwtExample {
	public static void main(String argv[]) {
//		Frame frame=new Frame();
//		frame.setBounds(30,60,50,70);
		AwtExample1 aaa = new AwtExample1();
		aaa.setVisible(true);
		aaa.setSize(100, 100);
		aaa.setBounds(300, 400, 50, 50);
	}

}
