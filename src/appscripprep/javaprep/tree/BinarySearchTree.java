package appscripprep.javaprep.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	// Insert Node
	public static Node add(Node root, int key) {

		if (root == null) {
			 return root = new Node(key);
		}
		if (root.data == key) {
			return root;
		} else if (root.data > key) {
			root.left = add(root.left, key);
		} else {
			root.right = add(root.right, key);
		}
		return root;
	}

	// Search Node
	// Time complexity:
//	Best case: O(log N)
	// Worst case: O(H) ,where H=height of tree
	public static boolean contains(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (root.data == key) {
			return true;
		}
		if (root.data > key) {
			return contains(root.left, key);
		}
		return contains(root.right, key);

	}

	// In order traversal
	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	// Delete a node
	public static Node delete(Node root, int key) {
		if (root.data > key) {
			root.left = delete(root.left, key);
		} else if (root.data < key) {
			root.right = delete(root.right, key);
		} else {//root.data == key
			//Case-1 leaf node
			if(root.left == null && root.right == null) {
				return null; //return null so that it's parent/root node will also set to null
			}
			//case-2 One Child
			if(root.left == null) {
				return root.right; //root.right will be referred by a root node where it is called
			}else if(root.right == null) {
				return root.left;
			}
			//Case-3 Two Child
			Node Is=inOrderSuccessor(root.right,key); //Left most child
			root.data=Is.data; //set root data with inOrder Successor
			root.right=delete(root.right, Is.data); //delete inOrder successor than automatically I-successor parent will point to I-successor child. 
			
		}
		return root;
	}
	//Print in range
	public static void range(Node root,int beg,int end) {
		if(root == null)return;
		//Lies in both end
		if(root.data >= beg && root.data <= end) {
			range(root.left, beg, end);
			System.out.print(root.data+" ");
			range(root.right, beg, end);
		}
		//Lies in left side
		else if(root.data >= end) {
			range(root.left, beg, end);
		}
		//Lies in right side
		else {
			range(root.right, beg, end);
		}
	}

	private static Node inOrderSuccessor(Node root, int key) {
		while(root.left != null) {
			root=root.left;
		}
		return root;
	}
	
	//print path
	public static void printNode2Leaf(Node root,ArrayList<Integer> path) {
		if(root == null) {
			return;
		}
		path.add(root.data);
		if(root.left == null && root.right == null) {
			printPath(path);
		}else {
			
			printNode2Leaf(root.left, path);
			printNode2Leaf(root.right, path);
		}
		path.remove(path.size()-1);
	}

	private static void printPath(ArrayList<Integer> path) {
		for(int data:path) {
			System.out.print(data+" ");
		}
		System.out.println();
	}
	//level Order
	public static void levelOrder(Node root) {
		if(root == null)return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()){
					return;
				}else {
					q.add(null);
					System.out.println();
				}
			}else {
				System.out.print(curr.data+" ");
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}
	public static void main(String[] args) {
		Node node = null;
//		add(node, 10);
//		add(node, 7);
//		add(node, 12);
//		add(node, 6);
//		add(node, 8);
//		add(node, 11);
//		add(node, 12);
		int[] arr = { 8,5,3,1,4,6,10,11,14 };
		for (int i = 0; i < arr.length; i++) {
			node = add(node, arr[i]);
		}
		System.out.println(contains(node, 8));
		inOrder(node);
//		System.out.println();
//		delete(node, 5);
//		inOrder(node);
//		System.out.println();
//		System.out.println("Printing in rang");
//
//		range(node, 3, 12);
//		//Print path
//		System.out.println();
//
//		System.out.println("Printing Path");
//
//		ArrayList<Integer> path = new ArrayList<>();
//		printNode2Leaf(node, path);
		System.out.println("Level order");
		levelOrder(node);
	}

}
