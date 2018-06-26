package bai7;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("E:\\java\\iotest\\acb.txt");

		try (RandomAccessFile randomAccess = new RandomAccessFile(file, "rw")) {
			randomAccess.seek(9);
			byte[] bytes = new byte[4 * 102];
			int read = randomAccess.read(bytes);
			System.out.println(new String(bytes, 0, read, "utf8"));
			randomAccess.seek(read);
			randomAccess.write("r\n".getBytes());
			randomAccess.writeChars("hello co can");

			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		}
	}
}
