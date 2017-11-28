package sum;


/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2. The given array will always start from 0 to the length - 1.
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 */
public class Missing_Number {
	
	/*
	 * Guass sum: 1+2+3+4+5+...+n = n(n+1)/2. Compute the target sum by nums length,
	 * then sum over all numbers in nums, minus to get the missing value.
	 */
	public int missingNumber(int[] nums) {
		int targetSum = (nums.length + 1) * nums.length / 2;
		int trueSum = 0;
        for (int number : nums) trueSum += number;
        return targetSum - trueSum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
