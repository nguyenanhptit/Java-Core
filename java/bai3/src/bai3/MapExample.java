package bai3;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new Hashtable<Integer, String>(); //hashable :
	map.put(3, "A");
	map.put(1, "B");
	map.put(2, "C");
	map.put(4, "X");
	System.out.println(map.get(3));
	map.put(3, "A1");
	System.out.println(map.get(3));
	}

}
