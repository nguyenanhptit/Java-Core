package bai7;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class ObjectReaderExample {
public static void main(String[] args) throws Exception {
	File folder = new File("E:\\java\\iotest\\abc.txt");
	ObjectInputStream input= null;
	input = new ObjectInputStream(new FileInputStream(new File(folder, "my_object")));
	Object obj = input.readObject();
	Method method = obj.getClass().getMethod("run", new Class[0]);
	method.invoke(obj, new Object[0]);
}
}
