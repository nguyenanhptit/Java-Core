package com.thuannd.controller;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class JsonLoaderClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/clazz/json");
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Acept", "Application/json");
			InputStream inputStream = connection.getInputStream();

			int read = 0;
			byte[] bytes = new byte[4 * 1024];
			while ((read = inputStream.read(bytes)) != -1) {
				System.out.println(new String(bytes, 0, read));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
