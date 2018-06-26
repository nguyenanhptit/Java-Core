package bai6;

public class newmain {
	
		public static void main(String[] args) {
			PrintMessage message = new PrintMessage("hello to everyone");
			PrintMessage message2 = new PrintMessage("hello to everyone");
//			message.run();
//			message2.run();
			
			
			
			
			
			Thread mess1=new Thread(message);
			Thread mess2=new Thread(message);
			mess1.start();
			mess2.start();
			System.out.println("ccc");
		}

	

}
