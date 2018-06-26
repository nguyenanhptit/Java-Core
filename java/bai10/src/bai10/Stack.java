package bai10;

public class Stack<Integer> {
private Node<Integer> current =null;
public Integer pop() {
  Integer result= current.value;
	current= current.next;
	return result;
	
}
public boolean hasNext() {
	return current != null;
}
public void push(Integer v) {
	Node<Integer> a= new Node<Integer>(v, current);
	this.current= a;
}
}
