package bai10;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(23);
		stack.push(45);
		stack.push(12);
		stack.push(89);
		stack.push(11);
		stack.push(25);
	
		while(stack.isEmpty()) {
			System.out.println("data" +stack.pop());
		}
	}

}
