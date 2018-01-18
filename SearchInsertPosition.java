package binarysearch;

/*
 * Given a sorted array and a target value, return the index 
 * if the target is found. If not, return the index where it 
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 1:
 * Input: [1,3,5,6], 0
 * Output: 0
 */

/*
 * Very straight forward search problem, use binary search to shorten search
 * time. If the target is found, return the middle number, otherwise, jump out
 * of the while loop, meaning left > right, at this time, the number at left > target,
 * while the number at right < target, so we should put target at left.
 */
public class SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l <= r) {
        	    int m = (l+r)/2;
        	    if(nums[m] > target) {
        	    	    r = m - 1;
        	    }
        	    else if (nums[m] < target) {
        	    	    l = m + 1;
        	    }
        	    else return m;
        }
        return l;
    }
	
	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		System.out.println(sip.searchInsert(new int[] {1,3}, 0));
	}

}
