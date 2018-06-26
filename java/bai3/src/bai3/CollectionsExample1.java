package bai3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionsExample1 {
	public static void main(String[] args) {
		Short[] values = { 1, 2, 4, 5, 6, 7, 8, 9 };
		List<Short> list = new ArrayList<Short>();
		Collections.addAll(list, values);
		Collections.reverse(list);
		list.toArray(values);
		for (Short a : values) {
		System.out.print(a + ",");
	}
		System.out.println("max va min la : "+ Collections.max(list)+" va "+ Collections.min(list));
}
}
