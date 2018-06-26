package bai9;

public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(()-> {
			System.out.println("say hello java class" + Thread.currentThread().getName());
			System.out.println("1+1" +(1+1));
		});
		new Thread().start();
	}
//Runnable runnable = new Runnable() {
//	
//	@Override
	public void run() {
		// TODO Auto-generated method stub
//		System.out.println(Thread.currentThread().getName()+"say hello ");
	}
//};
//	Thread thread = new Thread(runnable);
//	thread.start();
//	}

}
