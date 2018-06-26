package bai8;

import java.awt.Desktop;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class HttpConnectionExample {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("https://google.com/");
			URLConnection connection = url.openConnection();
			Path path = Paths.get("test.html");
			try (InputStream inputStream = connection.getInputStream();
					OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE,
							StandardOpenOption.APPEND)) {
				byte[] bytes = new byte[1024];
				int read;
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} finally {
				Desktop desktop = Desktop.getDesktop();
				desktop.open(path.toFile());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
