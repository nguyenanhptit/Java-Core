package bai6;

import java.util.Arrays;

public class SimpleThreadExample {
	public static void main(String[] args) {
		new Thread(() -> {
			Arrays.stream(args).forEach(ele -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("aaa");
				}
				System.out.println(ele + "");
			});
		}).start();
	}
}
