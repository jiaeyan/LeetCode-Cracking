package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of integers and an integer k, find out whether 
 * there are two distinct indices i and j in the array such that 
 * nums[i] = nums[j] and the absolute difference between i and j 
 * is at most k.
 */
public class ContainsDuplicateII {
	
	// keep a hashtable to record index of each distinct item,
	// if at i the item already has an index in the table, say j, compare
	// i with j; if (i - j <= k), return true, otherwise, since the pointer
	// keeps moving forward, the distance from j will only be longer
	// and impossible be shorter than (i-j), so update the item's index with i
	public boolean hash(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])){
				if(i - map.get(nums[i]) <= k) return true;
				map.put(nums[i], i);
			}
			else{
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	// slide the array with a window of length k, add all of them into
	// a set, if the adding doesn't happen for any item in that window,
	// there is duplicate items inside range of k, return true
	public boolean set(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			
			// from 0 to k, simply add items; from k to longer,
			// every time the window moves by 1, kick out the first
			// item in last window to keep the length with k
			if(i > k) set.remove(nums[i-k-1]);
			
			// if the adding doesn't happen inside the window, 
			// there is duplicate items in range of k
			if(!set.add(nums[i])) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
