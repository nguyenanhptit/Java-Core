package Bai22;
import java.util.stream.IntStream;
public class IntStreamExample {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		IntStream stream =  IntStream.range(998, 1000);
		stream.forEach(value->{
			if(builder.length()>0) builder.append(",");
			builder.append(value);
		});
	 System.out.println("text value= "+ builder);
	}

	}

