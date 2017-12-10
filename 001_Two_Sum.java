package sum;

import java.util.HashMap1;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 */
public class Two_Sum {

	public static void main(String[] args) {
		for (int each:twoSum(new int[]{2, 7, 11, 15}, 9)){
			System.out.println(each);
		}
	}
	
	public static int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> half = new HashMap<>();
		for (int i=0; i<nums.length; i++){
			if (half.containsKey(target - nums[i])) {
				return new int[]{half.get(target - nums[i]), i};
			}
			half.put(nums[i], i);
		}
		return null;
	}

}
