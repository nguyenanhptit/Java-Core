package bai6;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable {
	private String message;

	public PrintMessage(String message) {
		this.message = message;
	}

	@Override
//	public void run() {
//		String[] elements = message.split(" ");
//		Arrays.stream(elements).forEach(ele -> {
//			System.out.println(Thread.currentThread().getName() + " print " + ele);
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				 e.printStackTrace();
//			}
//		});
		
//			   try {
//				Thread.sleep((int)(Math.random()*3)*1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
//	}}
	public synchronized void run() {
		
			String[] elements = message.split(" ");			
			Arrays.stream(elements).forEach(ele -> {

			System.out.println(Thread.currentThread().getName() + "print" + ele);
			
	
			});
			for (int i = 0; i < 10; i++) {
				   System.out.println("in ra " +i );
				   try {
				Thread.sleep((int)(Math.random()*3)*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
		   }
	}
}






