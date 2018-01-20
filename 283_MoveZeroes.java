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
	public void naive(int[] nums) {
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
	
	
	
	
	// lastNonZeroFoundAt records the slow pointer, while cur is the fast pointer.
	// move cur, if not 0, put it at the lastNonZeroFoundAt, and move lastNonZeroFoundAt
	// by 1; otherwise, keep move cur and lastNonZeroFoundAt is untouched.
	public void moveZeroes(int[] nums) {
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
	        if (nums[cur] != 0) {
	            swap(nums, lastNonZeroFoundAt++, cur);
	        }
	    }
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = {4,2,4,0,0,3,0,5,1,0};
		mz.moveZeroes(nums);
		for(int num:nums) System.out.print(num);
	}

}
