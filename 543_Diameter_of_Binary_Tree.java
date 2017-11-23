package binary_search_tree;

/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * The length of path between two nodes is represented by the number of edges between them.
 */

public class Diameter_of_Binary_Tree {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
    public int diameterOfBinaryTree(TreeNode root) {
    	    return diameter(root, new int[] {0, 0})[0];
    }
    
    /*
	 * This approach is a variation of getHeight().
	 * We use array int[] info to record max diameter encountered so far at index 0,
	 * and higher height between left and right heights of current node at index 1.
	 */
    public int[] diameter(TreeNode node, int[] info) {                 //just interpret "diameter" here as height
		if (node == null) return new int[] {0, -1};                    //empty node's height = -1, while single node's height = 0
		int leftDiameter = diameter(node.left, info)[1];               //left height, already the longest path from some leaf to node
		int rightDiameter = diameter(node.right, info)[1];             //right height
		info[0] = Math.max(info[0], leftDiameter + rightDiameter + 2); //the diameter of current node = left height + right height + 2 edges around current node
		info[1] = Math.max(leftDiameter, rightDiameter) + 1;           //one level up, so + 1
		return info;
	}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
