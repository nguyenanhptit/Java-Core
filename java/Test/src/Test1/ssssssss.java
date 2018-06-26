package Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ssssssss {
	  public static void main(String[] args) { 
	List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
      Comparator<Integer> comparator = Integer::compare;
      Collections.sort(list, comparator);
      /*
      list.stream().filter(v -> v > 5).forEach(v ->{
          System.out.println(v);
      });*/
      Stream values = list.stream().filter(v -> v > 5);
      Object[] arr = values.toArray(size -> new Integer[size]);
      Arrays.stream(arr).forEach(c ->{
          System.out.println(c);
      });
      System.out.println("================");
      // IntSummaryStatistics
      Collector<Integer,?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
      IntSummaryStatistics summaryStatistics = list.stream().collect(collector);
      System.out.println("total = " + summaryStatistics.getSum());
      System.out.println("overage = " + summaryStatistics.getAverage());
      int sum = list.stream().reduce(0,(x,y) -> x+y);
      System.out.println("sum = " + sum);
      int sum2 = list.stream().reduce(0, Integer::sum);
      System.out.println("sum2 = " + sum2);
      System.out.println("================");
}
}

