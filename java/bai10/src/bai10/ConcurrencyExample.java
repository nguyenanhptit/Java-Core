package bai10;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {
	public static void addData(List list) throws InterruptedException {
		while (true) {
			int random = (int) (Math.random() * 1000);
			list.add(random);
			System.out.println(random);
			Thread.sleep(100);
		}
	}

	public static void printData(List list) {
		while (true) {
			try {
			System.out.println("============");
			list.forEach(value->System.out.println( value));
			
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List> list = new ArrayList<>();
		
		
		new Thread(()-> {
			try {
				addData(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()-> {
			try {
				printData(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}
	
}
