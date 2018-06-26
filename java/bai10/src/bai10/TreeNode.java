package bai10;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TreeNode<T> {
	private T value;
	private TreeNode<T> nextSibling;
	private TreeNode<T> firtChild;
	private TreeNode<T> parent;
	
	public TreeNode(T v){
		value=v;
	}

	public TreeNode(T value, TreeNode<T> nextSibling, TreeNode<T> firtChild, TreeNode<T> parent) {
		super();
		this.value = value;
		this.nextSibling = nextSibling;
		this.firtChild = firtChild;
		this.parent = parent;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getNextSibling() {
		return nextSibling;
	}

	public void setNextSibling(TreeNode<T> nextSibling) {
		this.nextSibling = nextSibling;
	}

	public TreeNode<T> getFirtChild() {
		return firtChild;
	}

	public void setFirtChild(TreeNode<T> firtChild) {
		this.firtChild = firtChild;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	
	public void addChild(TreeNode<T> child) {
		if(child== null ) return;
		child.parent= parent;
		if(firtChild==null) {
			firtChild=child;
		}else {
			TreeNode<T> temp = firtChild;
			while(temp.nextSibling!=null) {
				temp=temp.nextSibling;
			}
			temp.nextSibling=child;
		}
	
	}
	public TreeNode<T> addChild2(T value){
		TreeNode<T> node = new TreeNode<T>(value);
		addChild(node);
		return node;
	}
}

