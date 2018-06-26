package bai7;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class PathExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("E:\\java\\iotest\\acb.txt");
		System.out.println("this is " + (Files.isDirectory(path) ? "file" : " folder") + "!");
		System.out.println(Files.exists(path));
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
			for (Path p : directoryStream) {
				System.out.println(p.getFileName());
			}
		} catch (IOException ex) {
			// ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
