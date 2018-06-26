package bai6;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CallableSample implements Callable<Integer> {
//private ReentrantLock look = new ReentrantLock();
	@Override
	public Integer call() {
		// TODO Auto-generated method stub
		AtomicInteger total = new AtomicInteger(0);
		Thread current = Thread.currentThread();
		IntStream.range(0, 10).forEach(number ->{
			System.out.println( current.getName() + " -object "+this + "is running" +total.addAndGet(number));
		Random random = new Random();
		LongStream longStream = random.longs(100, 1000);
		 long sleep = longStream.findFirst().getAsLong();
		});
//		ReentrantLock lock = null;
//	//return total.get();
//	lock.lock();
//	lock.unlock();
	return total.get();
	}

}
