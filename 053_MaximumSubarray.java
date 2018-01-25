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
	 * must contain 1, we compare local (max subarray ends at previous position) + 1 < 1, so the max subarray is [1], local = 1;
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
//			System.out.println(local);	
			global = Math.max(global, local);
		}
		
		return global;
    }
	
	/*
     * Divide-and-conquer method.
     * The maximum summation of subarray can only exists under following conditions:
     * 1. the maximum summation of subarray exists in left half.
     * 2. the maximum summation of subarray exists in right half.
     * 3. the maximum summation of subarray exists crossing the midpoints to left and right. 
     * 1 and 2 can be reached by using recursive calls to left half and right half of the subarraies. 
     * Condition 3 can be found starting from the middle point to the left,
     * then starting from the middle point to the right. Then adds up these two parts and return. 
     * 
     * T(n) = 2*T(n/2) + O(n)
     * this program runs in O(nlogn) time
    */
	public int dividenconquer(int[] nums) {
	    int maxsum = subArray(nums, 0, nums.length-1);
	    return maxsum;
	}

	private int subArray(int[] A, int left, int right){
	    if (left == right){
	        //base case
	        return A[left];
	    }
	    int mid = left + (right-left)/2;
	    int leftsum = subArray(A, left, mid); //left part of the subarray sum, condition 1
	    int rightsum = subArray(A, mid+1, right); //right part of the subarray sum, condition 2
	    int middlesum = midSubArray(A, left, mid, right); //cross part of the subarray sum, condition 3
	    // System.out.println(leftsum);
	    // System.out.println(rightsum);
	    // System.out.println(middlesum);
	    
	    //following if condition will return middlesum if lost the "=" under the conditon of leftsum = rightsum, which may be problematic if leftsum = rightsum < middlesum.
	    //for example: [-1, -1, -2, -2], a.k.a., not able to handel all negative arrays
	    if (leftsum >= rightsum && leftsum >= middlesum){
	        return leftsum;
	    }
	    if (rightsum >= leftsum && rightsum >= middlesum){
	        return rightsum;
	    }
	    return middlesum;
	}

	private int midSubArray(int[] A, int left, int mid, int right){
	    int leftsum = Integer.MIN_VALUE;
	    int rightsum = Integer.MIN_VALUE;
	    int sum = 0;
	    for (int i = mid; i >= left; i--){
	        sum += A[i];
	        if (leftsum < sum){
	            leftsum = sum;
	        }
	    }
	    
	    sum = 0;
	    for (int j = mid + 1; j <= right; j++){
	        sum += A[j];
	        if (rightsum < sum){
	            rightsum = sum;
	        }
	    }
	    
	    return leftsum + rightsum;
	}
	
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.Kadane(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(ms.dividenconquer(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
