package binary_search_tree;

/*
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every 
 * node never differ by more than 1.
 * 
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents 
 * the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

/*
 * For a binary tree, the root's value should be the middle value, so that
 * all values at the left of it in the array will be < middle, while all values
 * at the right of it are > middle in the BST. The same to its left and right
 * children.
 */
public class SortedArray2BST {
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
        return convert(nums, 0, nums.length - 1);
    }
	
	public TreeNode convert(int[] nums, int l, int r) {
		if(l > r) return null;
		int mid = (l+r)/2;
		TreeNode t = new TreeNode(nums[mid]);
		t.left = convert(nums, l, mid - 1);
		t.right = convert(nums, mid + 1, r);
		return t;
	}
	
	/*
	 * Another idea, find current root, then find middle of left part
	 * and also middle of right part, assign its left and right children
	 * with those values, then make its left and right children respectively
	 * as new root, do the same thing.
	 * 
	 * This approach needs double check the ranges for left and right part
	 * in the same recursion.
	 */
//	public TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length == 0) return null;
//        int mid = (nums.length - 1) / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//        sort(root, nums, 0, mid, nums.length - 1);
//        return root;
//    }
//    
//    public void sort(TreeNode t, int[] nums, int l, int mid, int r) {
//        if(l <= mid-1) {
//            int ml = (l + mid - 1) / 2;
//            t.left = new TreeNode(nums[ml]);
//            sort(t.left, nums, l, ml, mid - 1);
//        }
//		  if(mid+1 <= r) {
//            int mr = (mid + 1 + r) / 2;
//		      t.right = new TreeNode(nums[mr]);
//            sort(t.right, nums, mid + 1, mr, r);
//        }
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
