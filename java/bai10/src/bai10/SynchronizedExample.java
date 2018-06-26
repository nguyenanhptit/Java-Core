package bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SynchronizedExample {

	public static void addData(List<Integer> list) {
		IntStream.range(0, 10).forEach(index -> {
			try {
				list.add(index);
				System.out.println(index);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.toString());
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<List<Integer>> values = new ArrayList<List<Integer>>();
		for (int i = 0; i < 5; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			new Thread(()->addData(list)).start();
			values.add(list);
			System.out.println();
		}
		try {
			Thread.sleep(5*1000);
			values.forEach(list-> System.out.println("number items of list ----->" + list.size()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
