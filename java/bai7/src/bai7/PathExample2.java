package bai7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.Line;

public class PathExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("E:\\java\\iotest");
		Path path2 = path.resolve("hanoijava.txt");
		Charset charset = Charset.forName("utf8");
		try(BufferedReader reader= Files.newBufferedReader(path2, charset)) {
		String line= null;
		while ((line= reader.readLine())!= null) {
			System.out.println(line);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			
		}
				
	}

}
