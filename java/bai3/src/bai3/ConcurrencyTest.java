package bai3;

import java.util.ArrayList;
import java.util.Collections;

public class ConcurrencyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<Integer> list = new ArrayList<Integer>();
Collections.addAll(list,1,3,4,2,3,6,3,3,8);
System.out.println("before remove:size of list = " + list.size());
	for(int i=0; i<list.size(); i++) {
		if(list.get(i)==3) list.remove(i);
		
	}
	System.out.println("after remove: size of list = "+ list.size());
	}

}
