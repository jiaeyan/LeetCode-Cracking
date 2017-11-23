package binary_search_tree;

/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 */

public class Minimum_Depth {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//The trick different from max depth here is that, according to the definition,
	//when a side's depth is 0, it's null, we cannot calculate the
	//distance between node and null as depth, so we switch to another side
	//null node is depth 0, single node is depth 1, two nodes is depth 2, ...
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);       //we don't know what side is 0 here, simply add all
        return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1:Math.max(leftDepth, rightDepth) + 1;
    }
	
	/*
	 * This is a more comprehensible approach to understand the idea.
	 */
//	public static int minDepth(TreeNode root) {
//		if (root == null)	return 0;
//		if (root.left == null)	return minDepth(root.right) + 1;
//		if (root.right == null) return minDepth(root.left) + 1;
//		return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
//	}
}
