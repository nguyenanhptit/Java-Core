package bai6;

public class PrintNumber implements Runnable {
	private Integer number = new Integer(1);
	private boolean alive = true;

	public int getNumber() {
		return number;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void run() {
		Thread current = Thread.currentThread();
		 synchronized (number) {
		// while (number<10) {
		// number++;
		// System.out.println(current.getName() + "number is \"" + number + "\"");
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// System.out.println(current.getName() + " stoped");
		// }
		while (number < 30) {
			number++;
			System.out.println(current.getName() + " number is \"" + number + "\"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("");
			}
			if (number % 10 == 0)
				break;
		}
		System.out.println(current.getName() + " stoped");

	}
}
}
