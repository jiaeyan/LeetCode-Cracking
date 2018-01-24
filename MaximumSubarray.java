package dynamicprogramming;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
 * which is more subtle.
 */


public class MaximumSubarray {
	
	/*
	 * Dynamic programming.
	 * 
	 * Maintain two values, one is local max, 
	 */
	public int Kadane(int[] nums) {
		if (nums.length == 0) return 0;
		
		int global = nums[0];
		int local = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			local = Math.max(nums[i], local + nums[i]);
			global = Math.max(global, local);
		}
		
		return global;
    }
	
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.Kadane(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
