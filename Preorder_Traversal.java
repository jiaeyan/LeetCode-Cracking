package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
 * return [1,2,3].
 */


public class Preorder_Traversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    public void traverse(TreeNode root, List<Integer> result){
        if (root != null){
            result.add(root.val);
            traverse(root.left, result);
            traverse(root.right, result);
        }
    }
}
