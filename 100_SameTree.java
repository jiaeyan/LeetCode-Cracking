package dfs;

/*
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and 
 * the nodes have the same value.
 */

public class SameTree {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
