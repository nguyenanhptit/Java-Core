package bai7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchFileNIOExample {
	public static void main(String[] args) throws IOException {
		Charset charset = Charset.forName("utf-8");
		Pattern pattern = Pattern.compile("s\\S ", Pattern.CASE_INSENSITIVE);
		File file = new File("E:\\java\\iotest\\acb.txt");
		RandomAccessFile stream;
		try {
			stream = new RandomAccessFile(file, "r");
			FileChannel channel = stream.getChannel();
			ByteBuffer bytes = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			CharBuffer chars = charset.decode(bytes);
			Matcher matcher = pattern.matcher(chars);

			if (matcher.matches()) {
				System.out.println("Found at" + Integer.toString(matcher.start()));
				System.out.println("Value" + chars.subSequence(0, chars.length()));
			} else {
				System.out.println("not found");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}