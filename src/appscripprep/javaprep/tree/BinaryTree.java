package appscripprep.javaprep.tree;

import java.util.Scanner;

public class BinaryTree {
	static Scanner scan=new Scanner(System.in);
	//Create Tree 
	public static Node createTree() {
		Node node=null;
		System.out.println("Enter data");
		int value = scan.nextInt();
		if(value == -1)return null;
		
		node=new Node(value);
		System.out.println("Enter data for left node of "+value);
		node.left=createTree();
		System.out.println("Enter data for Right node of "+value);
		node.right=createTree();
		return node;
	}
	//inorder
	public static void inOrder(Node root) {
		if(root == null) return ;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	
	//pre order
	public static void preOrder(Node root) {
		if(root == null) return ;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	//Post order
	public static void postOrder(Node root) {
		if(root == null) return ;
		
		postOrder(root.left);
		System.out.print(root.data+" ");
		postOrder(root.right);
		
	}
	
	public static void main(String[] args) {
		Node root = createTree();
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		
	}

}
