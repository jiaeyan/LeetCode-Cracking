package twopointers;

/*
 * Given an array nums, write a function to move all 0's to the end 
 * of it while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */


public class MoveZeroes {
	
	// Two pointers.
	// The left pointer is the current item, while the right pointer
	// moves fast to target the item that is not 0.
	// Every time the left pointer is a 0, find the non-0, swap, both
	// move on by 1; otherwise, just both move on by 1.
	public void moveZeroes(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return;
        int l = 0;
        int r = 1;
        while (l < nums.length && r < nums.length) {
        	    if(nums[l] == 0) {
        	    	    // find the item that is non-0
        	    	    while(r < nums.length && nums[r] == 0) r++;
        	    	    // r may reach length after above
        	    	    if(r >= nums.length) return;
        	    	    // swap
        	    	    nums[l] = nums[r];
        	    	    nums[r] = 0;
        	    }
        	    l++;
        	    r++;
        }
    }
	
	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = {4,2,4,0,0,3,0,5,1,0};
		mz.moveZeroes(nums);
		for(int num:nums) System.out.print(num);
	}

}
