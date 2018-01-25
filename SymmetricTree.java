package dfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 * But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

public class SymmetricTree {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	// besides root, its left subtree should be the reflection of its
	// right subtree, so: if root.left.val == root.right.val, then we divide it
	// into two subtrees left and right, then recursively check if (left.left == right.right)
	// && (left.right == right.left).
	public boolean recursive(TreeNode root) {
		return root == null || check(root.left, root.right); 
    }
	
	public boolean check(TreeNode l, TreeNode r) {
		if(l == null && r == null) return true;
		if(l == null || r == null) return false;
		return (l.val == r.val) && check(l.left, r.right) && check(l.right, r.left);
	}
	
	
	// a BFS approach, use a queue to store left and right, poll both
	// every time and compare
	public boolean iterative(TreeNode root) {
		if(root == null) return true;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root.left);
		q.add(root.right);
		while(!q.isEmpty()) {
			TreeNode l = q.poll();
			TreeNode r = q.poll();
			if(l == null && r == null) continue;
			if(l == null || r == null) return false;
			if(l.val != r.val) return false;
			q.add(l.left);
			q.add(r.right);
			q.add(l.right);
			q.add(r.left);
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
