package bai7;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderWriterExample {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\java\\iotest\\acb.txt");
//		boolean append;
//		try (FileWriter writer = new FileWriter(file, append = true)) {
//			writer.write("\r\n");
//			writer.write("Tran thi B");			
		
		FileReader reader= null;
		reader = new FileReader(file);
		char[] buffer =new char[4*1024];
		int read =-1;
		StringBuilder builder = new StringBuilder();
		while((read = reader.read(buffer))!=-1) {
			builder.append(buffer,0,read);
		}
		System.out.println(builder);
	}
}
