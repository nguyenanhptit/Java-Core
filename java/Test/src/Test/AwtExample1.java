package Test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;


public class AwtExample1 extends Frame  {
	public AwtExample1() {
		setLayout(new FlowLayout());
		Button pushButton=new Button("click on me");
		add(pushButton);
	}
	
}

