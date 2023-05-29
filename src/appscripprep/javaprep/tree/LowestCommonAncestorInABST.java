package appscripprep.javaprep.tree;

public class LowestCommonAncestorInABST {
	 //Function to find the lowest common ancestor in a BST. 
		Node LCA(Node root, int n1, int n2)
		{
		   //case-1 Both are greater than root data, so LCA and element must lie in right sub-tree
	        if(n1 > root.data && n2 > root.data ){
	            return LCA(root.right,n1,n2);
	        }
	        //case-2 Both are smaller than root data, so LCA and element must lie in Left sub-tree
	        else if(n1 < root.data && n2 < root.data){
	            return LCA(root.left,n1,n2); 
	        }
	        else{//case-1 one is greater and other is smaller than root
	            return root;
	        }
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
