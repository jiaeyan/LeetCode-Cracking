package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a non-empty binary tree, return the average value of the nodes 
 * on each level in the form of an array.
 * Example 1:
 * Input:
    3
   / \
  9  20
    /  \
   15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */

public class Average_of_Levels {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {return result;}
        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
		    int count = q.size();
            double sum = 0.0;
            for (int i = 0; i < count; i++){
                TreeNode node = q.remove();
                sum += node.val;
			    if (node.left != null) {q.add(node.left);}
			    if (node.right != null) {q.add(node.right);}
            }
            result.add(sum/count);
		}
        return result;
    }
}
