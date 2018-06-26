package bai6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LookExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newWorkStealingPool(4);
	CallableSample sample = new CallableSample();
	List<CallableSample> callables = Arrays.asList(sample, sample, sample,sample);
	try {
		executor.invokeAny(callables);
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}