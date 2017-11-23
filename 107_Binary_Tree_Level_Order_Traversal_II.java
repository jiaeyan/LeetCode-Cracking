package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the bottom-up level order traversal 
 * of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 * return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */


public class Level_Order_Traversal_II {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>(); //linkedlist in java is double linkedlist, cheap to insert at the beginning
        if (root == null) {return levels;}
        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {  //every loop is one level
			int count = q.size();
            List<Integer> sublevel = new ArrayList<>();
            while (count > 0) {
				TreeNode node = q.remove();
                sublevel.add(node.val);
			    if (node.left != null) {q.add(node.left);}
			    if (node.right != null) {q.add(node.right);}
			    count--;
			}
            levels.add(0, sublevel);
		}
        return levels;
    }
}
