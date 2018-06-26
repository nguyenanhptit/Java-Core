package Longngu;

public class ArrayExample {
	public static void main(String[] args) {
		float[]values = {4.5f, 5.5f};
		float total = 0;
		for(float value: values) {
			total += value;
		}
		System.out.println("the total value of array is " + total);
		float max = values[0];
		
		for (float max1: values)  {
//		int i=0;
			
			
			if(max < max1) {
//			max1++;
				max= max1;
				
			}
		}
		System.out.println("gia tri lon nhat =" + max);
	}
}