package bai6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ExecutorService executor = Executors.newFixedThreadPool(3);
Map	<String, String> map = new HashMap<String, String>();
ReadWriteLock lock=new ReentrantReadWriteLock();
	executor.submit(()->{
	System.out.println("start writing");
	lock.writeLock().lock();
		try {
			TimeUnit.SECONDS.sleep(10);
			map.put("foo", "bar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}finally {
		System.out.println("end writing");
		lock.writeLock().unlock();
	}
	});
	

		Runnable readTask = ()->{
	System.out.println("start reading");
	try {
		System.out.println(map.get("foo"));
	
	}finally {
		System.out.println("end reading");
	}
};
//executor.submit(readTask);
//executor.submit(readTask);
	}

}
