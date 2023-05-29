package appscripprep.javaprep.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeafNode {
	boolean check(Node root) {
		Queue<Node> q = new LinkedList<>();
		int currHeight = 1;
		int gHeight = 0;
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Node curr = q.remove();
			
			// Count level/Height
						if (curr == null) {
							if (q.isEmpty())
								return true;
							else {
								q.add(null);
								currHeight++;
								continue;
							}
						}
			// Check left
			if (curr.left != null) {
				q.add(curr.left);
				//if leaf node
				if(curr.left.left == null && curr.left.right == null) {
					//First leaf node
					if(gHeight == 0) gHeight=currHeight;
					//
					else if(gHeight != currHeight)return false;
				}
			}
			// check right
			if (curr.right != null) {
				q.add(curr.right);
				//if Leaf node
				if(curr.right.left == null && curr.right.right == null) {
					//First leaf node
					if(gHeight == 0) gHeight=currHeight;
					//
					else if(gHeight != currHeight)return false;
				}
			}

			
		}

		return true;

	}

	public static void main(String[] args) {

	}

}
