package multiplication;

import java.util.Arrays;
/*
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 */


public class Maximum_Product_of_Three_Numbers {
	
	/*
	 * Sort first.
	 * Either the two smallest negatives at the left most multiply to be the largest product of two,
	 * or the two biggest positives at the right most. Former one needs the biggest on the right most
	 * to be the largest product of three, and the latter just needs one more from right. 
	 */
	public int maximumProduct(int[] nums) {
		if (nums.length < 3) return -1;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length-1], nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1]);
    }
	
	/*
	 * Instead of sorting, loop through the array once and get the two smallest and the three
	 * biggest, compare the products of each and return the bigger one.
	 */
//	public int maximumProduct(int[] nums) {
//        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//        for (int n: nums) {
//            if (n <= min1) {
//                min2 = min1;
//                min1 = n;
//            } else if (n <= min2) {     // n lies between min1 and min2
//                min2 = n;
//            }
//            if (n >= max1) {            // n is greater than max1, max2 and max3
//                max3 = max2;
//                max2 = max1;
//                max1 = n;
//            } else if (n >= max2) {     // n lies betweeen max1 and max2
//                max3 = max2;
//                max2 = n;
//            } else if (n >= max3) {     // n lies betwen max2 and max3
//                max3 = n;
//            }
//        }
//        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
//    }
	
	public static void main(String[] args) {
		Maximum_Product_of_Three_Numbers mp = new Maximum_Product_of_Three_Numbers();
		System.out.println(mp.maximumProduct(new int[] {7, -10, 5, -1}));
	}

}
