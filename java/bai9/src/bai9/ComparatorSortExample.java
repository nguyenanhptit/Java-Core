package bai9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorSortExample {
public static void main(String[] args) {
//	Integer[] values = {12,345,34,7,9,12,9};
//	Arrays.sort(values ,(Integer a, Integer b) ->{
//			return b-a ;
//		}
//	);
//	for(Integer ele:values) {
//		System.out.print(ele+ ",");
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 1, 3, 5, 7, 6));
    Collections.sort(list);
    list.forEach(e -> System.out.println(e));
//	}
}
}
