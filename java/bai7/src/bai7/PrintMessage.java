package bai7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PrintMessage implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	private String msg;

	public PrintMessage(String msg) {
		this.msg = msg;
	}

	static class ObjectWriterExample {
		public static void main(String[] args) throws Exception {
			File folder = new File("E:\\java\\iotest");
			ObjectOutputStream output = null;
			FileOutputStream fileOutput = new FileOutputStream(new File(folder, "iotest"));
			output = new ObjectOutputStream(fileOutput);
			// PrintMessage printMessage = new PrintMessage();
			output.writeObject(new PrintMessage("can noi noi"));
			// close output
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
