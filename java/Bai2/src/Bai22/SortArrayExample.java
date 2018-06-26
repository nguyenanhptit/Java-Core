package Bai22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class SortArrayExample {
	public static void main(String[] args) {
		Integer[] mang = { 1, 9, 5, 6, 8, 3, 7, 4, 2 };
		Arrays.sort(mang);
		for (int a : mang) {
			System.out.println(a);
		}
		System.out.println("==========");
		Arrays.sort(mang, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int a : mang) {
			System.out.println(a);
		}
		Stream<Integer> stream = Arrays.stream(mang);
		Optional<Integer> max = stream.max((Integer o1, Integer o2) -> {
			return o1 - o2;
		});
		System.out.println("gia tri lon nhat = " + max.get());
	}

}
