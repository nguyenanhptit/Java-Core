package bai10;

public class Node<T> {
T value;
Node<T> next;
Node(T v){
	value =v;
	
}
Node(T v, Node<T>n){
	this.value= v; 
	this.next= n;
}
 

public T getValue() {
	return value;
}
public void setValue(T value) {
	this.value = value;
}
public Node<T> getNext() {
	return next;
}
public void setNext(Node<T> next) {
	this.next = next;
}
}
