package bai6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.naming.spi.DirStateFactory.Result;

public class FeatureExampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableSample callableSample = new CallableSample();
		ExecutorService executor = Executors.newScheduledThreadPool(1);
		Future<Integer> future = executor.submit(callableSample);      // qua trinh nhet callable vao threadpool
		System.out.println("Future Done? " + future.isDone());
	
			Integer result = 1;
			try {
				result = future.get(3,TimeUnit.SECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(" Future Done ?"+ future.isDone() + " - result=" + result);
	}

}
