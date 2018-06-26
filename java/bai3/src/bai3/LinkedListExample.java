package bai3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class LinkedListExample {
	public static void main(String[] args) {


		List <String> list = new LinkedList<String>();
		
		list.add("A");
		
	
//		for (String ele: list) { 
//			list.add(ele);
//
//		}
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println("" + iterator.next());
		}

	}
}