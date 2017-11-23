package binary_search_tree;

import java.util.ArrayList;
import java.util.List;


/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 * return [3,2,1].
 */

public class Postorder_Traversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(TreeNode root, List<Integer> result){
        if (root != null){
            traverse(root.left, result);
            traverse(root.right, result);
            result.add(root.val);
        }
    }
}
