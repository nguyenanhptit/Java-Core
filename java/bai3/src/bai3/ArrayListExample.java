package bai3;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, args);
		IntStream.range(0,list.size()).forEach(i ->{
			System.out.println(" element at "+i +"i" + list.get(i));
		});
	}
}
