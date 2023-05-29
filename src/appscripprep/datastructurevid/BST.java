package appscripprep.datastructurevid;


public class BST {
	private Node root;

	private class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		public Node() {
			super();
		}

	}

	// add
	private Node addNode(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}

		if (root.data > data) {
			root.left = addNode(root.left, data);
		} else if (root.data < data) {
			root.right = addNode(root.right, data);
		}
		return root;
	}

	// add Method
	public void add(int data) {
		this.root=addNode(this.root, data);
	}

	// In-order traversal
	private void printForwardUtil(Node root) {
		if (root == null) {
			return;
		}
		printForwardUtil(root.left);
		System.out.println(root.data);
		printForwardUtil(root.right);
	}
	// pre-order traversal
	private void printForwardUtil1(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data+" ");
		printForwardUtil1(root.left);
		printForwardUtil1(root.right);
	}
	// post-order traversal
	private void printForwardUtil2(Node root) {
		if (root == null) {
			return;
		}
		printForwardUtil2(root.left);
		printForwardUtil2(root.right);
		System.out.println(root.data);
	}

	// Abstraction
	public void printForward() {
		printForwardUtil(this.root);
	}
	
	//REmoveutio
	public Node removeUtil(Node root,int target) {
		//If target not found
		if(root == null) {
			return null;
		}
		//Recurse down the tree to find the value
		if(root.data > target) {
			root.left=removeUtil(root.left, target);
		}
		else if(root.data < target) {
			root.right=removeUtil(root.right, target);
		}
		// target found
		else{
			// Case-1 (leaf node)
			if(root.left == null && root.right == null) {
				return null;
			}
			//Case-2 (Only one child)
			else if(root.right != null && root.left == null) {
				return root.right;
			}
			else if(root.left != null && root.right == null) {
				return root.left;
			}
			//Case-3 (Two child)
//			root.data == target
			else {
				//left most inOrderSuccessor, bcoz successor is next of root node
				//Successor : left most node in root.right subtree.
				//predecessor : Right most node in roo.left subtree.
				//You can achieve this by both [successor and predecessor].
			Node successor=inOrderSuccessor(root.right);
			root.data=successor.data;
			root.right=removeUtil(root.right, successor.data);
			}
		}
		return root;
	}
	//Remove
	public void remove(int target) {
		root=removeUtil(root, target);
	}

	private Node inOrderSuccessor(Node root) {
		while(root.left != null) {
			root=root.left;
		}
		return root;
	}

	// MAIN METHOD
	public static void main(String[] args) {
		BST bst = new BST();
		bst.add(10);
		bst.add(5);
		bst.add(20);
		bst.add(3);
		bst.add(7);
		bst.add(15);
		bst.add(25);

		bst.printForward();
		bst.remove(10);
		System.out.println();
		bst.printForward();
//		bst.remove(20);
//		System.out.println();
//		bst.printForward();
		

	}
}
