package bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	Collections.addAll(list, "tu");
	Collections.addAll(list, "an");
	Collections.addAll(list, "hoa");
	Collections.addAll(list, "binh");
	for(int i=0; i< list.size(); i++) {
		System.out.print(list.get(i)+ ",");
	
	}
	System.out.println();
	System.out.println("vi tri thu " + Collections.binarySearch(list, "hoa"));
}
}
