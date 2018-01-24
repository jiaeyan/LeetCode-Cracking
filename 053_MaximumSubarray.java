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
	 * At each point in the array, there is a max subarray before it (which
	 * may not start from 0). So we simply start from 1st item, then extend the
	 * array one by one, and find the max subarray of that extended subarray, this
	 * extended subarray must contain the current item.
	 * 
	 * Local: the max sum of subarray that ends at current position, the end position must be included; 
	 *        so when extend to next position, compare (local + next item) vs next item to see which
	 *        is bigger; if here local > 0, the new local value of extended subarray must be (local + next item); 
	 *        otherwise, the new local value for next position will be the next item.
	 *        this ensures the subarray is continuous
	 * Global: the max of all max sums among different subarrays that end at each position in the array
	 * 
	 * [−2,1,−3,4,−1,2,1,−5,4]
	 * Start from -2, the max subarray to -2 is [-2], local(max sum) = -2;
	 * extend to 1, the subarray is [-2, 1], since now we are considering the max subarray that
	 * must contain 1, we compare local + 1 < 1, so the max subarray is [1], local = 1;
	 * extend to -3, the subarray is [-2, 1, -3], we consider the max subarray that must contain
	 * -3, so compare local + -3 = -2 > -3, so the max subarray contains -3 is [1, -3], local = -2;
	 * extend to 4, the subarray is [-2, 1, -3, 4], we consider the max subarray that must contain
	 * 4, so compare local + 4 < 4, so the max subarray contains 4 is [4], local = 4;
	 * ...
	 * So we can see, if the former local < 0, the next max subarray will directly start with the new
	 * item, because (local + new item) < new item.
	 * the next max subarrays at each position are [4, -1], [4, -1, 2], [4, -1, 2, 1], [4, -1, 2, 1, -5],
	 * [4, -1, 2, 1, -5, 4], with local values of 3, 5, 6, 1, 5, so among all these local values,
	 * the global max is 6.
	 * 
	 * In particular, every max subarray must not start with negative item, because this makes the sum smaller;
	 * also any continuous items in a max subarray must sum to positive, otherwise it makes the sum smaller.
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
