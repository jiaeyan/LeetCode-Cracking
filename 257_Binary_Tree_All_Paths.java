package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */

public class All_Paths {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root != null) getPath(root, "", paths);
        return paths;
    }
    
	// string is immutable, so here we create new string instances over and over again,
	// no concern to change string back like stringbuilder
    private void getPath(TreeNode root, String path, List<String> paths) {
        if (root.left == null && root.right == null) paths.add(path + root.val);
        if (root.left != null) getPath(root.left, path + root.val + "->", paths);
        if (root.right != null) getPath(root.right, path + root.val + "->", paths);
    }
}
