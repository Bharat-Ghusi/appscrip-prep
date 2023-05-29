package appscripprep.javaprep.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Tree {
	// Create a tree
	static Scanner sc = new Scanner(System.in);

	public static Node createTree() {
		Node node = null;
		System.out.println("Enter data.");
		int data = sc.nextInt();
		if (data == -1) {
			return null;
		}

		node = new Node(data);

		System.out.println("Enter data for left node " + data);
		node.left = createTree();
		System.out.println("Enter data for right node " + data);
		node.right = createTree();
		return node;
	}

	// Binary tree traversal

//	1-In order traversal
	public static void inOrder(Node root) {
		// Base condition
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

//	1- Pre-order traversal
	public static void preOrder(Node root) {
		// Base condition
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

//	1-Post-order traversal
	public static void postOrder(Node root) {
		// Base condition
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}

	// GET HEIGHT
	public static int getHeight(Node root) {
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	// Size of tree / Number of node in a tree
	public static int size(Node root) {
		if (root == null)
			return 0;
		return size(root.left) + size(root.right) + 1;
	}

	// Maximum data in a tree
	public static int maxData(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maxData(root.left), maxData(root.right)));
	}

	// Minimum data in a tree
	public static int minData(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(minData(root.left), minData(root.right)));
	}

	// Level order
	public static void levelOrder(Node root) {
		if(root == null)return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node curr = q.remove();// Current Node
			// TO print in hierarchical manner
			if (curr == null) {
				if (q.isEmpty()) {
					return;
				} else {
					// print a new line
					
					q.add(null);
					System.out.println();
				}
			} else {
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}

		}
	}

//	MAIN METHOD
	public static void main(String[] args) {
		Node root = createTree();
		inOrder(root);
		System.out.println();

		preOrder(root);
		System.out.println();

		postOrder(root);
		System.out.println();

		levelOrder(root);

		System.out.println();
		System.out.println("Height: " + getHeight(root));
		System.out.println("Size: " + size(root));
		System.out.println("Max data: " + maxData(root));
		System.out.println("Min data: " + minData(root));
	}

}
