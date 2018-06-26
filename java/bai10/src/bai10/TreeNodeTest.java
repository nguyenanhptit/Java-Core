package bai10;

public class TreeNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<String> root = new TreeNode<>("0");
		System.out.println(root);
		TreeNode<String> node1= new TreeNode<String>("1.0");
		root.addChild(node1);
		System.out.println(node1.getValue());
		root.addChild(new TreeNode<String>("1.1"));
		root.addChild(new TreeNode<String>("1.2"));
		root.addChild(new TreeNode<String>("1.3"));
		
		TreeNode<String> node2 = node1.getNextSibling();
		System.out.println(node1.getValue()+ " is "+ node2.getValue());
		
		node2.addChild2("2.0.0");
		node2.addChild2("2.1.0");
		node2.addChild2("2.1.1");
		
		TreeNode<String> node3 = node2.getNextSibling();
		System.out.println(node2.getValue()+ " is "+ node3.getValue());
		
		
	}

}
