package bai7;

import java.io.File;

public class FileExample {
	public static void main(String[] args) {
		File file = new File("E:\\java\\btjava");
		// if(file.isFile()) {
		// System.out.println("This is file");
		// }else {
		// System.out.println("This is folder");
		// }
		System.out.println("This is" + (file.isFile() ? "file" : " folder") + " !");
		File[] files = file.listFiles();
		for (File t : files) {
			System.out.println(t.getName());
			System.out.println(t.getName() + ":" + "bytes");
		}
	}
}
