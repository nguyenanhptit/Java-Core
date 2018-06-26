package bai10;

public class TestNode {
 private static void test(Node<?> node) {
	 while ( node != null) {
		 System.out.println("value is " + node.getValue());
		 node= node.next;
	 }
	 
 }
 public static void main(String[] args) {
	Node<String> root = new Node<String>("Step 1");
	Node<String> node1= new Node<String>("Step 2");
	Node<Integer> root2= new Node<Integer>(99, new Node<Integer>(23, new Node<Integer>(11)));
	root.next= node1;
		test(root);
		test(root2);
}
}
