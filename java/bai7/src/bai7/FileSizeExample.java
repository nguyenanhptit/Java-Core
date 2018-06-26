package bai7;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
	private static long getSize(File file) {
		if (file.isFile())
			return file.length();
		AtomicLong length = new AtomicLong(0);
		/*
		 * Arrays.stream(file.list()).forEach(f->{ length.getAndSet(length.longValue()
		 * +(f.?getSize(f): f.length)); });
		 */
		Arrays.stream(file.listFiles()).forEach(f -> {
			length.getAndSet(length.longValue() + (f.isFile() ? getSize(f) : f.length()));
		});
		return length.longValue();
	}

	// File[] files = file.listFiles();
	// int length =0 ;
	// for ( int i=0 ; i< files.length; i++) {
	// if( files[i].isFile()) {
	// length += getSize(files[i]);
	// continue;
	//
	// }
	// length += files[i].length();
	// }
	// return length;
	//
	// }
	//
	public static void main(String[] args) {
		File file = new File("E:\\java\\iotest");
		System.out.println("size" + getSize(file) / (1024 * 1024) + "MB");
	}
}
