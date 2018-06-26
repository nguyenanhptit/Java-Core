package bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.attribute.standard.NumberUpSupported;

public class ColectionOperation {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
		Comparator<Integer> comparator = Integer::compare;
		Collections.sort(list, comparator);
		list.stream().filter(v -> v > 5).forEach(v -> {
			System.out.println(v);
		});
		// Stream<Integer> values = list.stream().filter(v -> v>5);
		// Object[] a = values.toArray(size -> new Integer[size]);
		// Arrays.stream(a).forEach(v->{
		// System.out.println(v);
		// });
		Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
		IntSummaryStatistics summaryStatistics = list.stream().collect(collector);
		System.out.println("total = " + summaryStatistics.getSum());
		System.out.println("overage = " + summaryStatistics.getAverage());
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(" tong " + sum);
		int sum1 = list.stream().reduce(0, Integer::sum);
		System.out.println(" tong1" + sum1);
		Consumer<Integer> myConsumer = n -> {
			System.out.println(" user input value=" + n);
			if (n < 5) {
				System.out.println("invalid");
				return;
			}
			list.add(n);
			System.out.println("values:");
			list.forEach(x -> {
				System.out.print(x + " - ");
			});

		};
		myConsumer.accept(10);
		// Scanner scanner = new Scanner(System.in);
		// while(true) {
		// System.out.println(" input number");
		// int value = scanner.nextInt();
		// myConsumer.accept(value);
		// System.out.println();

		Predicate<Integer> tester = v -> v > 5;
		Consumer<Integer> myConsumer1 = n -> list.add(n);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(" input number");
			int value = scanner.nextInt();
			if (value < 0)
				break;
			if (tester.test(value))
				myConsumer.accept(value);
			System.out.println();
		}
		list.forEach(x -> {
			System.out.println(x + "-");
		});
	}
}
