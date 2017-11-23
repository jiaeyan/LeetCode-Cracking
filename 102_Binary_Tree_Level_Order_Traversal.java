package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 * return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

public class Level_Order_Traversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
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
            levels.add(sublevel);
		}
        return levels;
    }
}
