package bai9;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

 interface WindowClosing extends WindowListener {

default void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
 
	default void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		default void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
			default void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		@Override
			default void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		@Override
			default void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
}

