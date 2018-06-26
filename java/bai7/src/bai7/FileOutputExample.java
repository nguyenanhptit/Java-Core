package bai7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.INPUT_STREAM;

public class FileOutputExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		File file =  new File("E:\\java\\iotest\\acb.txt" );
//		FileOutputStream outputStream = null;
//		try {
//			outputStream = new FileOutputStream(file);
//			String str = "hello ha noi java class";
//			byte[] bytes = str.getBytes();
//			outputStream.write(bytes);
//		}catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(outputStream != null) outputStream.close();
//		}
		File file =  new File("E:\\java\\iotest\\acb.txt" );
	try(FileInputStream inputStream = new FileInputStream(file)){
		byte[] bytes = new byte[4*1024];
		int read= -1;
		StringBuilder builder = new StringBuilder();
		while((read= inputStream.read(bytes))!= 1) {
			builder.append(new String(bytes, 0, read));
		}
		System.out.println("["+ builder+ "]");
		inputStream.read(bytes);
		System.out.println(new String(bytes));
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
