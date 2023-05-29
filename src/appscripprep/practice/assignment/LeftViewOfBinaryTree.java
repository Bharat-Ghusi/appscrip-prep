package appscripprep.practice.assignment;

import java.util.ArrayList;

import appscripprep.javaprep.tree.Node;

public class LeftViewOfBinaryTree {
	 //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
    	ArrayList<Integer> list = new ArrayList<>();
    	list.add(root.data);
    	while(root.left != null) {
    		root=root.left;
    		list.add(root.data);
    	}
    	
		return list;
     
      
    }

	public static void main(String[] args) {
		
	}

}
