package Longngu;

public class MultidimensionalArrayExample {
	public static void main(String[] args) {
		String[][] values= {
				{"doan","van","a"},
				{"tran","van","b"}
		};
		for(int i=0 ; i< values.length; i++ ) {
			System.out.print("l");
			for(int j= 0 ; j< values[i].length;j++) {
				System.out.print(i+","+j + "l");
			}
			System.out.println();

			System.out.print("l");
			for( int j = 0; j< values[i].length; j++) {
				System.out.print(values[i][j]+"l");
			}
		}
		System.out.println();
	}
}
